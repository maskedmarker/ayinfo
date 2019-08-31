$(function() {
	var firstQuery = true;
	$('#dg').datagrid({
		columns:[[
			{
				field: 'employeeId',
				title: 'ID',
				width: '6%',
				hidden: true
			},
			{
				field: 'employeeName',
				title: '姓名',
				width: '6%',
				frozen: true
			},
			{
				field: 'workType',
				title: '工作类型',
				width: '8%',
				sortable: true
			},
			{
				field: 'province',
				title: '户籍',
				width: '6%',
				sortable: true
			},
			{
				field: 'pictureId',
				title: '头像',
				width: '12%',
				sortable: false,
				formatter: function(value,row,index) {
					if (!value) {
						return "";
					}
					var pictureId = value;
					return '<img class="certificationPicture" alt="图像" style="width:150px;height:150px;margin:1px;" src="/pics/' + pictureId + '">';
				}
			},
			{
				field: 'birthday',
				title: '出生日期',
				width: '6%',
				sortable: true,
				formatter: function(value,row,index) {
					return $.fn.datebox.defaults.formatter(new Date(value));
				}
			},
			{
				field: 'age',
				title: '年龄',
				width: '4%',
				sortable: true
			},
			{
				field: 'zodiac',
				title: '属相',
				width: '4%',
				sortable: true
			},
			{
				field: 'height',
				title: '身高(cm)',
				width: '6%',
			},
			{
				field: 'weight',
				title: '体重(kg)',
				width: '4%',
				sortable: true
			},
			{
				field: 'workingAge',
				title: '工作年限',
				width: '6%',
				sortable: true
			},
			{
				field: 'mobileNo',
				title: '手机号码',
				width: '8%',
				sortable: true
			},
			{
				field: 'education',
				title: '学历',
				width: '6%',
				sortable: true
			},
			{
				field: 'expectedPay',
				title: '期望工资(元)',
				width: '7%',
				sortable: true
			},
//			{
//				field: 'addedBy',
//				title: '操作者',
//				width: '6%',
//				sortable: true
//			},
			{
				field: 'addedDate',
				title: '录入时间',
				width: '6%',
				sortable: true,
				formatter: function(value,row,index) {
					return $.fn.datebox.defaults.formatter(new Date(value));
				}
			},
			]],
			
			fit: true,
//		fitColumns: true,
			striped: true, //相邻行数据的颜色不同
			singleSelect:true,
			remoteSort:false,
			emptyMsg: '请点击查询数据',
			loadMsg: '正在查询数据,请稍等...',
			pagination: false, //显示分页toolbar，
			rownumbers: true, //显示行编号
			showHeader: true,
			showFooter: false,
			scrollbarSize: 10,
			
			onDblClickRow: function(index, row) {
				var selectedEmployee = row;
				window.open("employeeDetail.html?employeeId=" + selectedEmployee.employeeId);
			},
			
			toolbar: [
				{
					iconCls: 'icon-add',
					text: '增加',
					handler: function() {
						window.open("createEmployee.html");
					}
				},
				{
					iconCls: 'icon-edit',
					text: '编辑',
					handler: function() {
						var selectedEmployee = $('#dg').datagrid('getSelected');
						if (!selectedEmployee) {
							$.messager.alert('警告', '请单击选中你要编辑的员工');
							return;
						}
						window.open("editEmployee.html?employeeId=" + selectedEmployee.employeeId);
					}
				},
				{
					iconCls: 'icon-remove',
					text: '删除',
					handler: function() {
						var selectedEmployee = $('#dg').datagrid('getSelected');
						if (!selectedEmployee) {
							$.messager.alert('警告', '请单击选中你要删除的员工');
							return;
						}
						
						$.messager.confirm('警告', '确认要删除?', function(confirm) {
							if (confirm) {
								$.ajax({
									url: '/ayinfo/employee/deleteEmployeeDetail.do?employeeId=' + selectedEmployee.employeeId,
									type: 'get',
									success : function(resp) {
										$.messager.confirm('提示', '已删除');
										queryFuzzy();
									},
									error : function(resp) {
										$.messager.alert('警告', '上传信息失败,请联系管理员!');
									}
								});
							}
						});
					}
				},
				{
					iconCls: 'icon-search',
					text: '查询',
					handler: function() {
						if (firstQuery) {
							clearQueryCriteria();
						}
						$('#queryCriteriaWindow').window('open');
					}
				},
				]
	});
	
	$('#clearQueryCriteria', $('#queryCriteriaWindow')).bind('click', function() {
		clearQueryCriteria();
	});
	
	$('#queryFuzzy', $('#queryCriteriaWindow')).bind('click', function() {
		queryFuzzy();
	});
	
//	$('.easyui-datebox', $('#queryCriteriaWindow')).each(function(index, item) {
//		$(item).datebox({
//			formatter: function(date) {
//				var y = date.getFullYear();
//				var m = date.getMonth()+1;
//				var d = date.getDate();
//				return m+'/'+d+'/'+y;
//			}
//		});
//	});
	
	function getQueryCriteria() {
		var criteria = {};
		$('.easyui-textbox, .easyui-combobox, .easyui-numberspinner, .easyui-datebox').each(function() {
			var eleId = $(this).attr('id');
			var eleValue = $(this).textbox('getValue');
			if (eleValue != "" && eleValue != null) {
				criteria[eleId] = eleValue;
			}
		});
		
		return criteria;
	}
	
	function queryFuzzy() {
		firstQuery = false;
		var criteria = getQueryCriteria();
		var pageQuery = {
				page : 1,
				rows : 10000,	
		};
		$.extend(pageQuery, criteria);
		
		$('#win').window('close');
		$('#dg').datagrid('loading');
		$.ajax({
			url : '/ayinfo/employee/getPaginatedFuzzyList.do',
			type : 'post',
			contentType : 'application/json',
			data : JSON.stringify(pageQuery),
			dataType : 'json',
			success : function(resp) {
				if (resp.errCode == 0) {
					$('#dg').datagrid('loadData', resp.data);
				}
				$('#dg').datagrid('loaded');
			},
			error : function(resp) {
				console.log(resp);
				$('#dg').datagrid('loaded');
			}
		});
	}
	
	function clearQueryCriteria() {
		$('.easyui-textbox, .easyui-combobox, .easyui-numberspinner, .easyui-datebox').textbox('clear');
	}
	
	
	function clearQueryResult() {
		$('#dg').datagrid('loadData', []);
	}
});





