<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form id="account_regist_form" method="post" action="/C2/AccountRegistServlet">
			  <table>
			    <tr>
			      <td>
					<label>UserID<br>
					<input type="text" name="user_ID">
					</label>
			      </td>
			    </tr>
			    <tr>
			      <td>
					<label>Mail<br>
					<input type="text" name="mail">
					</label>
			      </td>
			    <tr>
			    <tr>
			      <td>
					<label>Password<br>
					<input type="password" name="pw">
					</label>
			      </td>
			    </tr>
			    <tr>
			      <td>
					<label>Nicname<br>
					<input type="text" name="nickname">
					</label>
			      </td>
			    <tr>
			    <tr>
			      <td>
					<input type="submit" name="submit" value="OK">
			      <td>
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
