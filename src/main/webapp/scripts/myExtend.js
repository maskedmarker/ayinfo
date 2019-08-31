//var str1 = "hello {0}".format("world"); //log   hello world
//var str1 = "我叫{0},性别{1}".format("美男子", "男"); //log 我叫美男子,性别男
//var user = {name: "美男子",sex: "男",age: 20};
//var str2 = "我叫{name},性别{sex},今年{age}岁".format(user); //我叫美男子,性别男,今年20岁
String.prototype.format = function() {
 if(arguments.length == 0) return this;
 var param = arguments[0];
 var s = this;
 if(typeof(param) == 'object') {
  for(var key in param)
   s = s.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
  return s;
 } else {
  for(var i = 0; i < arguments.length; i++)
   s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
  return s;
 }
}

function dateboxFormatter(value){
	var date = null;
	if (value instanceof Date) {
		date = value;
	} else if (value instanceof Number) {
		date = new Date(value);
	} else {
		return null;
	}
	
	var year = date.getFullYear();
	var month = date.getMonth()+1; //月份+1   
	var day = date.getDate(); 
	return  month+"/"+day+"/"+year;
}

jQuery.expr[':'].regex = function(elem, index, match) {
    var matchParams = match[3].split(','),
        validLabels = /^(data|css):/,
        attr = {
            method: matchParams[0].match(validLabels) ? 
                        matchParams[0].split(':')[0] : 'attr',
            property: matchParams.shift().replace(validLabels,'')
        },
        regexFlags = 'ig',
        regex = new RegExp(matchParams.join('').replace(/^\s+|\s+$/g,''), regexFlags);
    return regex.test(jQuery(elem)[attr.method](attr.property));
}

//通过element对象反查对应的easyUI组件类型
function getComponentType(target){
	var plugins = $.parser.plugins;
	for(var i=plugins.length-1; i>=0; i--){
		if ($(target).data(plugins[i])){
			return plugins[i];
		}
	}
	return null;
}

$.extend($.fn.filebox.methods, {
    getFile: function (myself) {
        var temp = $(myself).next().children("[type='file']");
        var file = document.getElementById(temp.attr("id"));

        if (file.files.length > 0) {
            // 若选中一个文件，则返回该文件的File对象
            return file.files[0];
        }

        // 若未选中不论什么文件，则返回null
        return null;
    }
});

//display picture
function loadUploadedPic(picSrc, container, delCallback) {
	if (picSrc == null) {
		return;
	}
	
	var html = $("#imageDisplayTemplate").html()
	var table = $($.parseHTML(html));
	var img = table.find('img.ssi-imgToUpload').first().attr('src', picSrc);
	var button = table.find('button').first().on('click', function() {
		var picId = picSrc.split('/').pop();
		table.remove();
		delCallback && delCallback(picId);
	});
	
	table.appendTo($(container));
}

function uploadFilebox(selector, success, error) {
	var pictures = $(selector).filebox('files');
	if (pictures.length == 0) {
		return null;
	}
	
	var formData = new FormData();
	var pictures = $(selector).filebox('files');
	for (var i = 0; i < pictures.length; i++) {
		formData.append("files", pictures[i]);
	}
	return	$.ajax({
		url: '/ayinfo/employee/uploadFiles.do',
		type: 'POST',
		data: formData,
		processData: false,
		contentType: false,
		dataType: 'json',
		success : success,
		error : error
	});		
}

function hasFile(selector) {
	var pictures = $(selector).filebox('files');
	return pictures.length != 0;
}