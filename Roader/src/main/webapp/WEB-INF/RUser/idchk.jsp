<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.RUserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form>
         <c:if test="${idChk == null }">
            <nav>
               <ul>
					가는길에 @ 로더스<br>
                  	아이디 찾기<br>
	<input type="text" name="ruserEmail" id="ruserEmail">이메일주소<br>
	<input type="submit" formaction="idChk" formmethod="post" id="idChkBtn" value="아이디 찾기">                  	
               </ul>
            </nav>
         </c:if>
		<c:if test="${idChk != null }">
		          ${idChk.ruserId}입니다.<br>
				<input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="완료">
		</c:if>
          <c:if test="${no == false}">
        	 아이디찾기 실패! 이메일을 확인해주세요.</p>
		</c:if>
      </form>

</body>
</html>