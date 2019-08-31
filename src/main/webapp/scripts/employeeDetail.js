var employeeDetail = {};

function queryEmployeeDetail(employeeId) {
	$.ajax({
		url : '/ayinfo/employee/getEmployeeDetailById.do',
		type : 'get',
		data: {employeeId: employeeId},
		dataType : 'json',
		success : function(resp) {
			if (resp.errCode == 0) {
				employeeDetail = resp.data;
				displayEmployeeDetail(employeeDetail);
				displayWorkingHistorys(employeeDetail);
				displayHeadPicture(employeeDetail);
				displayCertificationPictures(employeeDetail);
				displayFullBodyPicture(employeeDetail);
			}
		},
		error : function(resp) {
			console.log(resp);
		}
	});
}

function displayEmployeeDetail(employeeDetail) {
	$('table#employeeDetail span.fieldValue').each(function() {
		var span = $(this);
		var fieldName = span.attr('id');
		var fieldValue = employeeDetail[fieldName];
		if (fieldValue == null) {
			return;
		}
		if ('birthday' === fieldName && $.isNumeric(fieldValue)) {
			fieldValue = $.fn.datebox.defaults.formatter(new Date(fieldValue));
		}
		span.text(fieldValue);
	});
}

function displayWorkingHistorys(employeeDetail) {
	var workingHistorys = employeeDetail.workingHistorys;
	if (workingHistorys == null || workingHistorys == 0) {
		return;
	}
	
	$(workingHistorys).each(function(index, workingHistory) {
		var regExp = new RegExp('\n', 'gm');
		var des = workingHistory.des ? workingHistory.des.replace(regExp, '<br/>') : '';
		var html = '<span>' + des + '</span>';
		$('#workingHistorys ol').append(html);
	});
}

function displayCertificationPictures(employeeDetail) {
	if (employeeDetail.certificationPictures == null || employeeDetail.certificationPictures.length == 0) {
		return;
	}
	
	var certificationPictures = employeeDetail.certificationPictures.filter(function (element) {
		return 'certification' == element.pictureType;
	});
	
	$(certificationPictures).each(function(index, certificationPicture) {
		var html = '<img class="certificationPicture" alt="图像" style="width:500px;height:500px;margin:3px;" src="/pics/' + certificationPicture.pictureId + '">';
		$('#certificationPictures').append(html);
	});
}

function displayFullBodyPicture(employeeDetail) {
	if (employeeDetail.certificationPictures == null || employeeDetail.certificationPictures.length == 0) {
		return;
	}
	
	var fullBodyPictures = employeeDetail.certificationPictures.filter(function (element) {
		return 'fullBody' == element.pictureType;
	});
	
	$(fullBodyPictures).each(function(index, fullBodyPicture) {
		var html = '<img class="certificationPicture" alt="图像" style="width:500px;height:500px;" src="/pics/' + fullBodyPicture.pictureId + '">';
		$('#fullBodyPicture').append(html);
	});
}

function displayHeadPicture(employeeDetail) {
	if (employeeDetail.certificationPictures == null || employeeDetail.certificationPictures.length == 0) {
		return;
	}
	
	var headPictures = employeeDetail.certificationPictures.filter(function (element) {
		return 'head' == element.pictureType;
	});
	
	$('#pictureId').attr('src', '/pics/' + headPictures[0].pictureId);
}



$(function() {
	const urlParams = new URLSearchParams(window.location.search);
	const employeeId = urlParams.get('employeeId');
	queryEmployeeDetail(employeeId);
});



