<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/schedule_update.css">
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
		<div id="scheduledetailtitle">
			<p id="updateschedule">Schedule Detail</p>
		</div>
		<div id="form" class=boxradius>
			<c:forEach var="e" items="${scheduleList}">
			<form id="schedule_form" method="post" action="/C2/ScheduleUpdateServlet"><!--アクションにサーブレットを入力する-->
              <div id="formbox">
                <input type="hidden" name="id" value="${e.id}">
                <input type="date" id="day" name="deadline" value="${e.deadline}">
				<input type="text"  name="task" value="${e.task}">
				<br>
				<textarea name="contents">${e.contents}</textarea>
				<br>
		<div id="line">
				<input type="text" name="register" value="${e.register}">
			<div id="okdeletebutton">
              	<input type="submit" id="update" name="submit" value="OK" class=okdeletebutton>
              	<input type="submit" id="delete" name="submit" value="Delete" class=okdeletebutton>
            </div>
        </div>
      		</form>
      		</c:forEach>
      	</div>
    	</main>

		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script src="/C2/js/common.js"></script>
	</body>
</html>