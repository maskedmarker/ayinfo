var fieldNames = ['employeeName', 'gender', 'province', 'idNo', 'birthday', 'age', 'zodiac', 'height', 'weight', 
	'workingAge', 'mobileNo', 'education', 'expectedPay', 'workTypes', 'certifications','workingHistorys'];
var employeeDetail = {};
var submited = false;

$(function() {
	$('#employeeName').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.employeeName = newValue;
		}
	});
	$('#gender').combobox({
		onChange: function(newValue,oldValue) {
			employeeDetail.gender = newValue;
		}
	});
	$('#province').combobox({
		onChange: function(newValue,oldValue) {
			employeeDetail.province = newValue;
		}
	});
	$('#idNo').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.idNo = newValue;
		}
	});
	$('#birthday').datebox({
		onChange: function(newValue,oldValue) {
			employeeDetail.birthday = newValue;
		}
	});
	$('#age').numberspinner({
		onChange: function(newValue,oldValue) {
			employeeDetail.age = newValue;
		}
	});
	$('#zodiac').combobox({
		onChange: function(newValue,oldValue) {
			employeeDetail.zodiac = newValue;
		}
	});
	$('#height').numberspinner({
		onChange: function(newValue,oldValue) {
			employeeDetail.height = newValue;
		}
	});
	$('#weight').numberspinner({
		onChange: function(newValue,oldValue) {
			employeeDetail.weight = newValue;
		}
	});
	$('#workingAge').numberspinner({
		onChange: function(newValue,oldValue) {
			employeeDetail.workingAge = newValue;
		}
	});
	$('#mobileNo').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.mobileNo = newValue;
		}
	});
	$('#education').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.education = newValue;
		}
	});
	$('#expectedPay').numberspinner({
		onChange: function(newValue,oldValue) {
			employeeDetail.expectedPay = newValue;
		}
	});
	
	$('#workTypes').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.workTypes = employeeDetail.workTypes || [];
			if (newValue == null || newValue == "") {
				employeeDetail.workTypes.pop();
			} else {
				employeeDetail.workTypes[0] = newValue;
			}
		}	
	});
	
	$('#certifications').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.certifications = employeeDetail.certifications || [];
			if (newValue == null || newValue == "") {
				employeeDetail.certifications.pop();
			} else {
				employeeDetail.certifications[0] = newValue;
			}
		}	
	});
	
	$('#workingHistorys').textbox({
		onChange: function(newValue,oldValue) {
			employeeDetail.workingHistorys = employeeDetail.workingHistorys || [];
			if (newValue == null || newValue == "") {
				employeeDetail.workingHistorys.pop();
			} else {
				employeeDetail.workingHistorys[0] = {des: newValue};
			}
		}
	});
	
	$('.easyui-textbox, .easyui-combobox, .easyui-numberspinner, .easyui-datebox', $('.employeeDetail')).textbox('clear');
});



function addEmployeeDetail() {
	var dfd = jQuery.Deferred();
	$.ajax({
		url: '/ayinfo/employee/addEmployeeDetail.do',
		type: 'POST',
		data: JSON.stringify(employeeDetail),
		contentType : 'application/json',
		dataType: 'json',
		success : function(resp) {
			if (resp.errCode == 0) {
				$.messager.alert('提示', '提交信息成功!');
			} else {
				$.messager.alert('警告', resp.Msg);
			}
			dfd.resolve('addEmployeeDetail');
		},
		error : function(resp) {
			$.messager.alert('警告', '上传信息失败,请联系管理员!');
		}
	});
	
	return dfd;
}



function uploadHeadPicture() {
	var dfd = jQuery.Deferred();
	if (!hasFile('#headPicture')) {
		employeeDetail.certificationPictures = employeeDetail.certificationPictures || [];
		employeeDetail.certificationPictures.push({pictureType: 'head', pictureId: ayinfo.config.defaultHeadImage});
		dfd.resolve();
	} else {
		uploadFilebox('#headPicture', function(resp) {
			if (resp.errCode == 0) {
				pictureIds = resp.data;
				employeeDetail.certificationPictures = employeeDetail.certificationPictures || [];
				pictureIds.forEach(function(picId) {
					employeeDetail.certificationPictures.push({pictureType: 'head', pictureId: picId});
				});
				dfd.resolve('uploadHeadPicture');
			} else {
				$.messager.alert('警告', resp.Msg);
			}
		})
	}
	
	return dfd;
}

function uploadFullBodyPicture() {
	var dfd = jQuery.Deferred();
	if (!hasFile('#fullBodyPicture')) {
		dfd.resolve();
	} else {
		uploadFilebox('#fullBodyPicture', function(resp) {
			if (resp.errCode == 0) {
				var pictureIds = resp.data;
				employeeDetail.certificationPictures = employeeDetail.certificationPictures || [];
				pictureIds.forEach(function(picId) {
					employeeDetail.certificationPictures.push({pictureType: 'fullBody', pictureId: picId});
				});
				dfd.resolve('fullBodyPicture');
			} else {
				$.messager.alert('警告', resp.Msg);
			}
		})
	}
	
	return dfd;
}

function uploadCertificationPictures(success) {
	var dfd = jQuery.Deferred();
	if (!hasFile('#certificationPictures')) {
		dfd.resolve();
	} else {
		uploadFilebox('#certificationPictures', function(resp) {
			if (resp.errCode == 0) {
				var pictureIds = resp.data;
				employeeDetail.certificationPictures = employeeDetail.certificationPictures || [];
				pictureIds.forEach(function(picId) {
					employeeDetail.certificationPictures.push({pictureType: 'certification', pictureId: picId});
				});
				dfd.resolve('certificationPictures');
			} else {
				$.messager.alert('警告', resp.Msg);
			}
		})
	}
	
	return dfd;
}

function submitEmployeeDetail() {
	$.messager.confirm({
		title: '提示', 
		msg: '确认提交用户信息?',
		fn: function(r) {
			if (r) {
				$('#submit').linkbutton('disable');
				$('#clear').linkbutton('disable');
				var valid = validateInfo();
				if (!valid) {
					$('#submit').linkbutton('enable');
					$('#clear').linkbutton('enable');
					return;
				}
				
				$.when(uploadHeadPicture(), uploadFullBodyPicture(), uploadCertificationPictures())
				.done(addEmployeeDetail);
			}
		}
	});
}

function validateInfo() {
	for (var fieldName of fieldNames) {
		var fieldId = '#' + fieldName;
		var componentType = getComponentType(fieldId);
		var valid = $(fieldId)[componentType]('isValid');
		if (!valid) {
			var label = $(fieldId)[componentType]('options').label;
			label = label.replace(':', '');
			$.messager.alert('提示', '<b>' + label+'</b><br/>必填数据不能为空或者数据长度不合法!');
			return false;
		}
	}
	return true;
}

function closeCreateWindow() {
	$.messager.confirm({
		title: '提示', 
		msg: '确定关闭窗口?',
		fn: function(r) {
			if (r) {
				window.close();
			}
		}
	});
}