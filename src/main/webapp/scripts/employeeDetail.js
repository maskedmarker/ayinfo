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
				fillEmployeeDetail(employeeDetail);
				fillDetailAccordion(employeeDetail);
				$('#pictureId').attr('src', '/pics/' + employeeDetail.pictureId);
			}
		},
		error : function(resp) {
			console.log(resp);
		}
	});
}

function fillEmployeeDetail(employeeDetail) {
	$('#employeeDetail td.value span').each(function() {
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

function fillDetailAccordion(employeeDetail) {
	fillDataList('#workTypes', employeeDetail, 'workTypes', null);
	fillDataList('#certifications', employeeDetail, 'certifications', null);
	fillDataList('#workingHistorys', employeeDetail, 'workingHistorys', function(wh) {
		var st = new Date(wh.startDate).getYear() + 1900;
		var ed = new Date(wh.endDate).getYear() + 1900;
		return "{0}年-{1}年, {2}".format(st, ed, wh.des);
	});
}

function fillworkTypes(employeeDetail) {
	var workTypes = employeeDetail.workTypes;
	if (!$.isArray(workTypes)) {
		return;
	}
	var targetList = [];
	workTypes.forEach(function(item, index, array) {
		targetList.push({text: item});
	});
	$('#workTypes').datalist('loadData', targetList);
}

function defaultFormatter(item) {
	return item;
}

function fillDataList(selector, data, fieldName, formatter) {
	if (data === null) {
		return;
	}
	var rawList = data[fieldName];
	if (!$.isArray(rawList)) {
		return;
	}
	
	if (formatter === null) {
		formatter = defaultFormatter;
	}
	var targetList = [];
	rawList.forEach(function(item, index, array) {
		var content = formatter.call(item, item);
		targetList.push({text: content});
	});
	$(selector).datalist('loadData', targetList);
}

$(function() {
	const urlParams = new URLSearchParams(window.location.search);
	const employeeId = urlParams.get('employeeId');
	queryEmployeeDetail(employeeId);
});



