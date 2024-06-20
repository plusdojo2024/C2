<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/task.css">
	</head>


	<body>
		<header>
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>


		<main>
			<h2>New Schedule</h2>
			<c:forEach var="e" items="${accountList}" >
      		<form id="schedule_form" method="post" action="/C2/ScheduleRegistServlet"><!--アクションにサーブレットを入力する-->
                			<input type="text" name="task" placeholder="zoom会議">
                			<br>
                			<textarea name="contents" id="詳細" placeholder="14:00～"></textarea>
              				<br>
              				<input type="text" name="register" value="${e.nickname}" readonly="readonly">
              				<input type="submit" id="regist" name="submit" value="登録">
      		</form>
      		</c:forEach>
    	</main>


    	<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script src="/C2/js/common.js"></script>
	</body>
</html>