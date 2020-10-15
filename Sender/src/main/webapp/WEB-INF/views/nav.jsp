<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    	.main-sub-menu>ul {
    		height: 50px;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    	}
    	.main-sub-menu>ul li {
    		margin-right: 30px;
    	}
    	.main-sub-menu>ul li:last-child {
    		margin-right: 0;
    	}
    </style>
<meta charset="UTF-8">
</head>
<body>

 	 <nav class="main-sub-menu">
            <ul>
                <li><a href="/itemList">상품관리</a></li>
                <li><a href="/delivery/list">배송관리</a></li>
                <li><a href="User/read?SUSER_ID=${User.SUSER_ID}">회원관리</a></li>
            </ul>
      </nav>
</body>
</html>