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
			<div class="header-contents">
				<div class="header-content">
					<div class="gnavi__wrap">
						 <ul class="gnavi__lists">
							 <li class="gnavi__list">
						     	<a href="#"><img src="/C2/img/accountNull.png"></a>
						        <ul class="dropdown__lists">
						       		<li class="dropdown__list"><a href="/C2/AccountServlet">アカウント画面</a></li>
							       	<li class="dropdown__list"><a href="/C2/GroupServlet">グループ一覧</a></li>
							       	<li class="dropdown__list"><a href="/C2/GroupUpdateServlet">グループ詳細</a></li>
							       	<li class="dropdown__list"><a href="/C2/LogoutServlet">ログアウト</a></li>
						        </ul>
							</li>
						</ul>
					</div>
				</div>
				<h5></h5><!-- 空の枠 -->
				<h5></h5><!-- 空の枠 -->
				<div class="logo">
					<a href="/C2/ManualServlet" class="header-content"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
				</div>
				<h5></h5><!-- 空の枠 -->
				<h5></h5><!-- 空の枠 -->
				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>
		<main>
			<c:forEach var="e" items="${taskList}" >
            <form method="post" action="/C2/TaskServlet">
            	タスクの期限：${e.deadline}
            	<br>
                <input type="date" name="deadline">
                <input type="submit" name="dateChange" value="日付切替">
            </form>
            </c:forEach>
			<c:forEach var="e" items="${taskList}" >
				<form method="post" action="/C2/TaskServlet" >
					<input type="hidden" name="id" value="${e.id}">
					<input type="checkbox" name="checkbox" value="yes"<c:if test="${e.checkbox}">checked</c:if> disabled>
					<input type="text" name="task" value="${e.task}">
					<input type="text" name="to" value="${e.to}">
				</form>
			</c:forEach>
                   <a href="/C2/TaskServletRegist"><button>+</button></a>
            <br>
            schedule
           	<c:forEach var="e" items="${schedulesList}" >
            	<form method="post" action="/C2/TaskServlet">
            		<input type="text" name="schedule" value="${e.task}">
				</form>
            </c:forEach>
                   <a href="/C2/ScheduleRegistServlet"><button>+</button></a>
        </main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>