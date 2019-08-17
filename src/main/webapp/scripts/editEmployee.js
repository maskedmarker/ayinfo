var employeeDetail = {};
var submited = false;

$(function() {
	initEasyuiComponent();
	initData();
});

function initEasyuiComponent() {
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
	
	$('#workTypes').combobox({
		editable: false,
		multiple:true,
		panelHeight: 'auto',
		data: ayinfo.config.workTypes,
		onChange: function(newValue,oldValue) {
			employeeDetail.workTypes = newValue;
		}	
	});
	
	$('#certifications').combobox({
		editable: false,
		multiple:true,
		panelHeight: 'auto',
		data: ayinfo.config.certifications,
		onChange: function(newValue,oldValue) {
			employeeDetail.certifications = newValue;
		}	
	});

	$('#workingHistorys').textbox({
		icons : [ 
			{
				iconCls : 'icon-add',
				handler : function(e) {
					$('#dd').dialog('open');
				}
			},
		]
	});
	
	$('.easyui-textbox, .easyui-combobox, .easyui-numberspinner, .easyui-datebox', $('.employeeDetail')).textbox('clear');
}

function initData() {
	const urlParams = new URLSearchParams(window.location.search);
	const employeeId = urlParams.get('employeeId');
	queryEmployeeDetail(employeeId);
}

function initMainUIValue() {
	$('#employeeName').textbox('setValue', employeeDetail.employeeName);
	$('#gender').combobox('setValue', employeeDetail.gender);
	$('#province').combobox('setValue', employeeDetail.province);
	$('#idNo').textbox('setValue', employeeDetail.idNo);
	$('#birthday').datebox('setValue', $.fn.datebox.defaults.formatter(new Date(employeeDetail.birthday)));
	$('#age').numberspinner('setValue', employeeDetail.age);
	$('#zodiac').combobox('setValue', employeeDetail.zodiac);
	$('#height').numberspinner('setValue', employeeDetail.height);
	$('#weight').numberspinner('setValue', employeeDetail.weight);
	$('#workingAge').numberspinner('setValue', employeeDetail.workingAge);
	$('#mobileNo').textbox('setValue', employeeDetail.mobileNo);
	$('#education').textbox('setValue', employeeDetail.education);
	$('#expectedPay').numberspinner('setValue', employeeDetail.expectedPay);
	$('#workTypes').combobox('setValues', employeeDetail.workTypes || []);
	$('#certifications').combobox('setValues', employeeDetail.certifications || []);

	initWorkingHistoryUI();
}

function initWorkingHistoryUI() {
	if (!employeeDetail.workingHistorys || employeeDetail.workingHistorys.length == 0) {
		return;
	}
	
	for (var i = 0; i < employeeDetail.workingHistorys.length; i++) {
		appendWorkingHistoryPanel();
	}
	var index = 0;
	$("#workingHistorysPanelContainer .workingHistory").each(function() {
		var workingHistory = employeeDetail.workingHistorys[index++];
		$(".startDate", $(this)).datebox('setValue', $.fn.datebox.defaults.formatter(new Date(workingHistory.startDate)));
		$(".endDate", $(this)).datebox('setValue', $.fn.datebox.defaults.formatter(new Date(workingHistory.endDate)));
		$(".des", $(this)).textbox('setValue', workingHistory.des);
	});
}

function queryEmployeeDetail(employeeId) {
	//loading modal
	$.ajax({
		url : '/ayinfo/employee/getEmployeeDetailById.do',
		type : 'get',
		data: {employeeId: employeeId},
		dataType : 'json',
		success : function(resp) {
			if (resp.errCode == 0) {
				employeeDetail = resp.data;
				initMainUIValue();
			}
		},
		error : function(resp) {
			$.messager.alert('警告', '查询信息失败,请联系管理员!');
		}
	});
}

function updateEmployeeDetail() {
	$.ajax({
		url: '/ayinfo/employee/updateEmployeeDetail.do',
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
		},
		error : function(resp) {
			$.messager.alert('警告', '上传信息失败,请联系管理员!');
		}
	});				
}

function uploadHeadPicture() {
	var pictures = $('#picture').filebox('files');
	if (pictures.length == 0) {
		employeeDetail.pictureId = ayinfo.config.defaultHeadImage;
		return;
	}
	
	var formData = new FormData();
	formData.append("picture", pictures[0]);
	$.ajax({
		url: '/ayinfo/employee/uploadPicture.do',
		type: 'POST',
		async: false,
		data: formData,
		processData: false,
		contentType: false,
		dataType: 'json',
		success : function(resp) {
			if (resp.errCode == 0) {
				var pictureId = resp.data;
				employeeDetail.pictureId = pictureId;
			} else {
				$.messager.alert('警告', resp.Msg);
			}
		},
		error : function(resp) {
			$.messager.alert('警告', '图片上传失败,请联系管理员!');
		}
	});
}

function submitEmployeeDetail() {
	$.messager.confirm({
		title: '提示', 
		msg: '确认提交用户信息?',
		fn: function(r) {
			if (r) {
				$('#submit').linkbutton('disable');
				var valid = validateInfo();
				if (!valid) {
					$('#submit').linkbutton('enable');
					return;
				}
				
				uploadHeadPicture();
				updateEmployeeDetail();
			}
		}		
	});
}

function validateInfo() {
	var fields = ['#employeeName', '#gender', '#province', '#idNo', '#birthday', '#age', '#zodiac', '#height', '#weight', 
		'#workingAge', '#mobileNo', '#education', '#expectedPay', '#workTypes', '#certifications'];
	for (var field of fields) {
		var componentType = getComponentType(field);
		var valid = $(field)[componentType]('isValid');
		if (!valid) {
			var label = $(field)[componentType]('options').label;
			label = label.replace(':', '');
			$.messager.alert('提示', '<b>' + label+'</b><br/>数据格式不合法,请确认后再提交信息!');
			return false;
		}
	}
	return true;
}

function clearPreparedInfo() {
	$.messager.confirm('提示', '确认清除待提交用户信息?', function(r) {
		if (r) {
			$('.easyui-textbox, .easyui-combobox, .easyui-numberspinner, .easyui-datebox', $('.employeeDetail')).textbox('clear');
		}
	});
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

function appendWorkingHistoryPanel() {
	var copy = $($.parseHTML($("#workingHistoryPanelTemplate").html())).appendTo($("#workingHistorysPanelContainer"));
	$.parser.parse(copy);
}

function removeWorkingHistoryPanel() {
	var workingHistoryPanelList = $(".workingHistory");
	if (workingHistoryPanelList == null || workingHistoryPanelList.length === 0) {
		return;
	}
	workingHistoryPanelList.last().remove();
}

function confirmWorkingHistoryPanel() {
	var valid = validateWorkingHistorys();
	if (!valid) {
		return;
	}
	var workingHisList = getWorkingHisList();
	employeeDetail.workingHistorys = workingHisList;
	$('#dd').dialog('close');
}

function getWorkingHisList() {
	var workingHisList = [];
	var workingHistoryPanelList = $(".workingHistory");
	if (workingHistoryPanelList == null || workingHistoryPanelList.length === 0) {
		return workingHisList;
	}
	
	workingHistoryPanelList.each(function(index, workingHistoryPanel) {
		var startDate = $('.startDate', workingHistoryPanel).datebox('getValue');
		var endDate = $('.endDate', workingHistoryPanel).datebox('getValue');
		var des = $('.des', workingHistoryPanel).textbox('getValue');
		var workingHistory = {
				startDate: startDate,
				endDate: endDate,
				des: des,
		};
		workingHisList.push(workingHistory);
	});
	return workingHisList;
}

function validateWorkingHistorys() {
	var workingHistorys = $('.workingHistory');
	if (workingHistorys.length == 0) {
		return true;
	}
	
	var fieldClsz = ['.startDate', '.endDate', '.des'];
	for (var i = 0; i < workingHistorys.length; i++) {
		var workingHistory = workingHistorys[i];
		var itemValid = true;
		for (var fieldCls of fieldClsz) {
			var field = $(fieldCls, workingHistory);
			var componentType = getComponentType(field);
			var valid = $(field)[componentType]('isValid');
			if (!valid) {
				var label = $(field)[componentType]('options').label;
				label = label.replace(':', '');
				$.messager.alert('提示', '<b>' + label+'</b><br/>数据格式不合法,请确认后再提交信息!');
				itemValid = false;
				break;
			}
		}
		if (!itemValid) {
			return false;
		}
	}
	
	return true;
}