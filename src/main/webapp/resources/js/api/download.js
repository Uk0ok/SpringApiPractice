$(function (){
	$('#downButton').on('click', function() {
		let elementId = $('#downElementId').val();
		
		let downloadJson = new FormData();
		downloadJson.append('elementId', elementId);

		let success = function(result) {
			console.log('download success');
		}

		let error = function(result) {
			console.log('download failed');
		}

		AjaxUtil.ajax("/api/download", "POST", downloadJson, success, error);
	})
});

let AjaxUtil = {
	ajax : function($url, $type, $data, $success, $error, $async) {	
		let $json = ($data) ? JSON.stringify($data) : "";
		
		let $asyncOpt = ($async) ? true : false;
		
		$.ajax({
			headers : { 
		        'Accept' : 'application/json',
		        'Content-Type' : 'application/json' 
			},
			url : $url,
			type : $type,
			async : $asyncOpt,
			beforeSend : function() {
				$('.wrap-loading').css('display', 'flex');
			},
			complete : function() {
				$('.wrap-loading').css('display', 'none');
			},
			dataType : 'json',
			data : $json,
			contentType : 'application/json;charset=UTF-8',
			mimeType : 'application/json',
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
