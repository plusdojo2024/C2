<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css" "/C2/css/task.css">
	</head>


	<body>
		<header>
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>


		<main>
			<h2>New Schedule</h2>
      		<form id="schedule_form" method="post" action="/C2/ScheduleRegistServlet"><!--アクションにサーブレットを入力する-->
        		<table class="table">
          			<tr>
            			<td>
                			<input type="text" name="heading" placeholder="zoom会議">
            			</td>
          			</tr>
          			<tr>
            			<td>
                			<textarea name="detail" id="詳細" placeholder="14:00～"></textarea>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>パパ<br>
              				</label>
            			</td>
            			<td>
                			<input type="submit" id="regist" name="submit" value="登録">
            			</td>
          			</tr>
        		</table>
      		</form>
    	</main>


    	<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script src="/C2/js/common.js"></script>
	</body>
</html>