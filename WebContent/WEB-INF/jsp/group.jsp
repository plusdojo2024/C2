<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
	</head>
	<body>
		<header>
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->

		</header>
		<main>
			<c:forEach var="e" items="${cardList}" >
			<form class="glist"method="get" action="/C2/GroupServlet" ><!--グループ選択  -->
				<a href="/C2/ManualServlet"><input type="text" value="${e.group_name}"></a>
			</form>
			</c:forEach>
			<a href="/C2/GroupCreateServlet"> <img src="/C2/img/" alt="新規作成"></a>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>