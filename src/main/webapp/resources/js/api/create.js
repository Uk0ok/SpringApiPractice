$(function (){
	$('#createButton').on('click', function() {
		let file = document.getElementById('createFile').files[0];
		let description = $('#createDescription').val();
		let cClassId = $('#createcClassId').val();
		let userClass = $('#createUserClass').val();
		let eClassId = $('#createeClassId').val();
		let createNumber = $('#createNumber').val();
		
		let createJson = new FormData();

		createJson.append('file', file);
		createJson.append('description', description);
		createJson.append('cClassId', cClassId);
		createJson.append('userClass', userClass);
		createJson.append('eClassId', eClassId);
		createJson.append('createNumber', createNumber);

		let success = function(result) {
			console.log('create success');
		}

		let error = function(result) {
			console.log('create failed');
		}

		
		AjaxUtil.ajaxFile("/api/create", "POST", createJson, success, error);
	})
	
	
});

let AjaxUtil = {
	ajaxFile : function($url, $type, $data, $success, $error) {
		$.ajax({
			enctype: 'multipart/form-data',
			url : $url,
			type : $type,
			async : true,
			beforeSend : function() {
				$('.wrap-loading').css('display', 'flex');
			},
			complete : function() {
				$('.wrap-loading').css('display', 'none');
			},
			data : $data,
			contentType : false,
			processData : false,
			success : function(response, textStatus) {
				if (textStatus=="success")
					$success(response);
				else
					$error(response);
			},
			error : function(response) {
				if (response.status=="200")
					$success(response);
				else
					$error(response);
			}
		});
	}
}
