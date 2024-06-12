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
      		<form id="account_form" method="post" action=""><!--アクションにサーブレットを入力する-->
        		<table class="table">
          			<tr>
            			<td>
              				<label>User ID<br>
                				<input type="text" name="userId">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Mail<br>
                				<input type="text" name="mail">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Password<br>
                				<input type="text" name="password">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>New Password<br>
                				<input type="text" name="newPassword">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Nickname<br>
                				<input type="text" name="nickname">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<input type="submit" id="register" name="submit" value="登録">
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

