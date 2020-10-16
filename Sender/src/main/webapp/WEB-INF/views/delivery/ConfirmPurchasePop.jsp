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
	평가 점수
	<ul class="review-list">
		<li>
			친절
			<input type="hidden" value="1">
			<select name="kindly" class="kindly-select">
				<option value="5">★★★★★
				<option value="4">★★★★☆
				<option value="3">★★★☆☆
				<option value="2">★★☆☆☆
				<option value="1">★☆☆☆☆
			</select>
		</li>
		<li>
			약속 			
			<input type="hidden" value="2">
			<select name="promise" class="promise-select">
				<option value="5">★★★★★
				<option value="4">★★★★☆
				<option value="3">★★★☆☆
				<option value="2">★★☆☆☆
				<option value="1">★☆☆☆☆
			</select>
		</li>
		<li>
			속도
			<input type="hidden" value="3">
			<select name="speed" class="speed-select">
				<option value="5">★★★★★
				<option value="4">★★★★☆
				<option value="3">★★★☆☆
				<option value="2">★★☆☆☆
				<option value="1">★☆☆☆☆
			</select>
		</li>
	</ul>
	<textarea class="review-message" name="reviewContent" placeholder="리뷰메시지"></textarea><br>
	<input type="hidden" name="deliveryNumber" class="del-num-input"><br>
	<input type="hidden" name="ruserId" class="ruser-input"><br>
	<input type="hidden" name="reviewRegistor" class="suser-input"><br>
	<button type="button" class="review-btn">평가 및 배송확정</button>
	
	<script>

		$(document).ready(function(){

			/*부모창에 있는 정보 가져와서 자식 팝업에 넣어주는 역할을 함*/
			$('.del-num-input').val($(opener.document).find(".delivery-number-input").val());
			$('.ruser-input').val($(opener.document).find(".ruser-id-input").val());
			$('.suser-input').val($(opener.document).find(".suser-id-input").val());

			$('.review-btn').click(function(){

				var selectTotal
				= (parseInt($('.kindly-select').val())
				+ parseInt($('.promise-select').val())
				+ parseInt($('.speed-select').val()))/3;

				var totalStar = Math.ceil(selectTotal);

				//json 형식으로 데이터 set
				var params = {
					DELIVERY_NUMBER: $('.del-num-input').val(),
					ruserId: $('.ruser-input').val(),
					SUSER_ID: $('.suser-input').val(),
					reviewContent: $('.review-message').val(),
					kindly: $('.kindly-select').val(),
					promise: $('.promise-select').val(),
					speed: $('.speed-select').val(),
					totalStar: totalStar
				}
				
				// ajax 통신
				
				$.ajax({
					type : "POST",            // HTTP method type(GET, POST) 형식이다.
					url : "/delivery/confirm",      // 컨트롤러에서 대기중인 URL 주소이다.
					data : params,            // Json 형식의 데이터이다.
					success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
						close();
						opener.parent.location.reload();
					},
					error : function(request, status, error){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
						//console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error);
					}
				});
				
			})

		})

	</script>

</body>
</html>