$(function (){
	$('#downButton').on('click', function() {
		let elementId = $('#downElementId').val();

		console.log(elementId);

		if(elementId.trim() =='' || elementId.trim == null){
			alert('데이터를 입력해주세요')
			return;
		}

		let success = function(result) {
			console.log('download success');
		}

		let error = function(result) {
			console.log('download failed');
		}

		AjaxUtil.ajax("/api/download", "POST", elementId, success, error);
	})
});

let AjaxUtil = {
	ajax : function($url, $type, $data, $success, $error, $async) {	
		let $json = ($data) ? JSON.stringify($data) : "";
		let $asyncOpt = ($async) ? true : false;

		console.log($json);
		
		$.ajax({
			url : $url,
			type : $type,
			async : $asyncOpt,
			beforeSend : function() {
				$('.wrap-loading').css('display', 'flex');
			},
			complete : function() {
				$('.wrap-loading').css('display', 'none');
			},
			// json data는 ""가 붙어있어 ""를 제거하는 과정이 필요
			data : $json.replace(/"/g,''),
			dataType : 'JSON',
			contentType: 'application/json',
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
