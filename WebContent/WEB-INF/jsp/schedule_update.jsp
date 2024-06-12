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
			<h2>Schedule Detail</h2>
			<form id="schedule_form" method="post" action="/C2/ScheduleUpdateServlet"><!--アクションにサーブレットを入力する-->
        		<table class="table">
          			<tr>
            			<td>
              				<input type="text" name="heading"  placeholder="授業参観">
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<textarea name="detail" id="詳細" placeholder="スリッパ持っていく"></textarea>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>ママ<br>
              				</label>
            			</td>
            			<td>
              				<input type="submit" id="update" name="submit" value="更新">
            			</td>
            			<td>
              				<input type="submit" id="delete" name="submit" value="削除">
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