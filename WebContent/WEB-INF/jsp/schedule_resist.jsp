<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/schedule_regist.css">
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
		<div id="newscheduletitle">
			<p id="newschedule">New Schedule</p>
		</div>
		<div id="form" class=boxradius>
			<c:forEach var="e" items="${accountList}" >
      		<form id="schedule_form" method="post" action="/C2/ScheduleRegistServlet"><!--アクションにサーブレットを入力する-->
	            <div id="formbox">
	                        <input type="date" id="day" name="deadline">
                			<input type="text" name="task" placeholder="スケジュール">
                			<br>
                			<textarea name="contents" id="詳細" placeholder="詳細"></textarea>
              				<br>
              		<div id="line">
              				<input type="text" name="register" value="${e.nickname}" readonly="readonly">
              			<div id="okbutton">
              				<input type="submit" id="regist" name="submit" value="OK" class=okbutton>
      					</div>
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
		<script type="text/javascript">
        //今日の日時を取得
        window.onload = function () {
            var date = new Date()
            var year = date.getFullYear()
            var month = date.getMonth() + 1
            var day = date.getDate()

            var toTwoDigits = function (num, digit) {
              num += ''
              if (num.length < digit) {
                num = '0' + num
              }
              return num
            }

            var yyyy = toTwoDigits(year, 4)
            var mm = toTwoDigits(month, 2)
            var dd = toTwoDigits(day, 2)
            var ymd = yyyy + "-" + mm + "-" + dd;

            document.getElementById("day").value = ymd;
        }
		</script>
	</body>
</html>