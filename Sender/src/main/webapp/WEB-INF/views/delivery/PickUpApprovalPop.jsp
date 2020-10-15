<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	픽업을 승인합니다.<br>
	<input type="text" name="DEL_MESSAGE" placeholder="픽업 승인 메시지"><br>
	<input type="hidden" name="DELIVERY_NUMBER" class="del-num-input">
	<button type="submit" class="approve-pickup">픽업 승인</button>

	<script>
	
		$(document).ready(function(){

			console.log($(opener.document).find(".delivery-number-input").val())
			$('.del-num-input').val($(opener.document).find(".delivery-number-input").val())
			
			$('.approve-pickup').click(function(){
	
				// json 형식으로 데이터 set
				var params = {
					DEL_MESSAGE : $('input[name="DEL_MESSAGE"]').val(),
	                DELIVERY_NUMBER : $('input[name="DELIVERY_NUMBER"]').val()
	        	}
	            
		        // ajax 통신
		        $.ajax({
		            type : "POST",            // HTTP method type(GET, POST) 형식이다.
		            url : "/delivery/aprovalPickUp",      // 컨트롤러에서 대기중인 URL 주소이다.
		            data : params,            // Json 형식의 데이터이다.
		            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
		                close();
		                window.opener.close();
		                location.reload();
		            },
		            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
		                
		            }
		        });
		
			})
		
		})

	</script>

</body>
</html>