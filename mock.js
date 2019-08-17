http://localhost:8080/ayinfo/employee/getById.do?employeeId=1

$.ajax({
	url : "/ayinfo/employee/getById.do?employeeId=2",
	success : function(resp) {
		console.log('>>>>>>>>>>>>>');
		console.log(resp);
		console.log('<<<<<<<<<<<<<');
	} 
});


(function(){
	var employeeInfo = {
			addedDate: null,
			addedBy: null,
			updatedDate: null,
			updatedBy: null,
			employeeId: null,
			employeeName: "李四",
			gender: null,
			birthday: null,
			age: null,
			zodiac: null,
			height: null,
			weigth: null,
			province: null,
			mobileNo: null,
			education: null,
			tag: null,
			workType: null,
			workingAge: null,
			certification: null,
			workingExperience: null,
			pay: null,
			pictureId: null
	};
	$.ajax({
		type : "post",
		url : "/ayinfo/employee/getList.do",
		data : JSON.stringify(employeeInfo),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(resp) {
			console.log('>>>>>>>>>>>>>');
			console.log(resp);
			console.log('<<<<<<<<<<<<<');
		} 
	});
})();


(function(){
	var employeeInfo = {
			addedDate: 1563100205000,
			addedBy: null,
			updatedDate: 1563100205000,
			updatedBy: null,
			employeeId: 4,
			employeeName: "李四",
			gender: null,
			birthday: null,
			age: 22,
			zodiac: null,
			height: null,
			weigth: null,
			province: null,
			mobileNo: null,
			education: null,
			tag: null,
			workType: null,
			workingAge: null,
			certification: null,
			workingExperience: null,
			pay: null,
			pictureId: null
	};
	$.ajax({
		type : "post",
		url : "/ayinfo/employee/add.do",
		data : JSON.stringify(employeeInfo),
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(resp) {
			console.log('>>>>>>>>>>>>>');
			console.log(resp);
			console.log('<<<<<<<<<<<<<');
		} 
	});
})();