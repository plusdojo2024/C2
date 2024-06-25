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
				<h5>${group_name}</h5><!-- 空の枠 -->
				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>
		<main>

            <!-- タスクの期限の表示 -->
            <div id="limit" >
           &ensp;${deadline}&emsp;
            <form method="post" action="/C2/TaskServlet">
                <input type="date" name="deadline">
                <input type="submit" name="dateChange" value="Day Change">
            </form>
            </div>

            <!-- タスクの一覧表示 -->
          <div id="all">
          <div class="flex-container">
            <div id="task" class="flex-item">
            <p id="tasktitle">Task&emsp;&emsp;</p>
			<c:forEach var="e" items="${taskList}" >
				<form method="get" action="/C2/TaskUpdateServlet" >
					<input type="hidden" name="id" value="${e.id}">
					<input type="checkbox" name="checkbox" value="yes"<c:if test="${e.checkbox}">checked</c:if> disabled>
					<input type="submit" name="task" value="${e.task}">
					<input type="text" name="to" value="${e.to}" readonly="readonly">
				</form>
			</c:forEach>
			    <p class=plusbutton>
                <a href="/C2/TaskServletRegist">
                  <img src="/C2/img/plusButton4.png">
                </a>
                </p>
            <br>
            </div>

            <!-- 予定の一覧表示 -->
            <div id="schedule" class="flex-item">
				<p id="scheduletitle">Schedule</p>
				<c:forEach var="e" items="${schedulesList}" >
					<form method="get" action="/C2/ScheduleUpdateServlet">
						<input type="hidden" name="id" value="${e.id}">
						&emsp;&emsp;<input type="submit" name="scheduleDetail" value="${e.task}">
					</form>
				</c:forEach>
				<p class=plusbutton>
				&emsp;
	            <a href="/C2/ScheduleRegistServlet">
	            <img src="/C2/img/plusButton4.png">
				</a>
				</p>
            </div>
			</div>
          </div>
        </main>

		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>