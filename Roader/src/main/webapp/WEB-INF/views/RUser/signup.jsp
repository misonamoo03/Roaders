<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>센더스</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/style.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/ruser/signup.js"></script>
<script src="/resources/ruser/postcode.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<script>
	$(function() {
		
		$("#allagre").click(function() {
			var chkA = $(this).is(":checked");//.attr('checked');
			if (chkA) {
				$("#essen").prop('checked', true);
				$("#option").prop('checked', true);
				all_cheack = "Y";
				ruserAgreEssen = "Y";
				ruserAgreOption = "Y";
			} else {
				$("#essen").prop('checked', false);
				$("#option").prop('checked', false);
				all_cheack = "N";
				ruserAgreEssen = "N";
				ruserAgreOption = "N";
			}
			console.log("ruserAgreEssen::::" + ruserAgreEssen);
		});

		$("#essen").click(function() {
			var chkE = $(this).is(":checked");
			if (chkE) {
				ruserAgreEssen = "Y";
			} else {
				ruserAgreEssen = "N";
			}
		});
		$("#option").click(function() {
			var chkO = $(this).is(":checked");
			if (chkO) {
				ruserAgreOption = "Y";
			} else {
				ruserAgreOption = "N";
			}
		});
		$('#essenId').click(
				function() {
					window.open("/essenPopup", "필수",
							"width=550, height=500, left=600, top=100");
				});
		$('#optionId').click(
				function() {
					window.open("/optionPopup", "선택",
							"width=550, height=500, left=600, top=100");
				});
		
		
	});
</script>


<body>
	<header class="header">
		<h1>
			<span class="font-color-orange">가는길에</span> @로더스
		</h1>
	</header>
	<main class="main signup-main">
		<section class="sign-up">
			<h1>
				가는길에 @ <span class="font-color-orange">로더스</span>
			</h1>
			<span>필수정보를 입력해주세요.</span> <input type="text" name="ruserId" size="40" placeholder="아이디 * (4~20)" maxlength="10"> 
			<span class="font-color-red d-none id-err"> &nbsp;&nbsp;아이디는 4자리 이상 10자리 이하 영문과 숫자만 입력해주세요. </span> 
			<span class="font-color-red d-none id-duple-err"> &nbsp;&nbsp;중복된 아이디 입니다. </span> 
			<span class="font-color-blue d-none id-confirm">
				&nbsp;&nbsp;사용 가능한 아이디 입니다. </span> 
			<input type="password" name="ruserPw" size="40" placeholder="비밀번호 * (영문 +숫자 8~20)" maxlength="10">
			<span class="font-color-red d-none pwd-err">
				 &nbsp;&nbsp;비밀번호는 4자리 이상 10자리 이하 영문과 숫자만 입력해주세요. 
			</span> 
			<input type="password" name="pwd-check" size="40" placeholder="비밀번호 재확인" maxlength="10"> 
			<span class="font-color-red d-none pwd-check-err">
				&nbsp;&nbsp;비밀번호가 일치하지 않습니다. 
			</span> 
			<span> 
				<input type="text" name="emailOne" placeholder="이메일아이디" maxlength="15"> @ 
				<select	name="emailTwo">
					<option value="@gmail.com">gmail.com</option>
					<option value="@naver.com">naver.com</option>
					<option value="@daum.net">daum.net</option>
					<option value="@nate.com">nate.com</option>
				</select>
			</span> 
			<input type="text" name="rphone" class="rphone" size="40" placeholder="휴대폰번호 * (00012345678)"> 
			<input type="text" name="ruserName" class="ruserName"  size="40" placeholder="이름"> 
			<span>선택정보를 입력해주세요.</span> 
			<span> <input type="text" class="zip required" name="ruserPostCode" readonly placeholder="우편번호">
				<button class="address-search-button">주소찾기</button>
				<p>
					<input type="text" class="address-basic required" name="addressOne" size="40" placeholder="주소" readonly="readonly">
				</p>
				<p>
					<input type="text" class="address-detail" name="addressTwo"	size="40" placeholder="상세 주소">
				</p>
			</span>
			<div>
				<input id="allagre" name="allagre" value="allagre" type="checkbox">	전체 약관에 동의 합니다.
			</div>
			<div>
				<input id="essen" name="essen" value="essen" type="checkbox">
				<a id="essenId">필수 항목에 동의 합니다.</a><br>
			</div>
			<div>
				<input id="option" name="option" value="option" type="checkbox">
				<a id="optionId"> 광고성 정보 수신 동의(선택)</a><br>
			</div>
			<input type="submit" value="회원가입" class="signup-button">
		</section>

	</main>
	<footer class="footer">
		<h1>(주) 미소나무</h1>
		<div class="company">
			<dl>
				<dt>사업자 등록번호:</dt>
				<dd>217-81-41971</dd>
			</dl>
			<dl>
				<dt>대표:</dt>
				<dd>손성택</dd>
			</dl>
			<dl>
				<dt>주소:</dt>
				<dd>경기도 남양주시 덕송2로 70-9 504호</dd>
			</dl>
			<dl>
				<dt>대표번호:</dt>
				<dd>02) 6232-7000</dd>
			</dl>
			<dl>
				<dt>fax:</dt>
				<dd>02) 6232-7700</dd>
			</dl>
		</div>
		ⓒ Misonamoo Corp
	</footer>
</body>
</html>