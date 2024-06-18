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
			<form id ="update" method="post" action="/C2/GroupUpdateServlet"><!--  -->
			<table>
			<tr>
			  <td><input type="file" name="image"></td>
			  <td><input type="text" name="name" value="${e.group_name}"></td>
			</tr>
			<tr>
			  <td><h2>MEMBER</h2></td>
			  <td><input type="text" value ="${e.nickname}"></td>
			  <td><button onclick="deleteExample(this);">-</button></td>
			  <td><input type="checkbox" class="agreement"></td>
			</tr>
			<tr>
			  <td><h2>MEMBER</h2></td>
			  <td><input type="text" placeholder= "例：para_man"></td>
			  <td><input type="submit" value="招待"><td>
			</tr>
			<tr>
			  <td><input type="submit" value ="登録"></td>
			</tr>
			</table>
			</form>
			</c:forEach>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
		<script src="/C2/js/group.js"></script>
	</body>
</html>