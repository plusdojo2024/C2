<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet"  href="/C2/css/account.css">
	</head>
	<body>
		<header>
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
		<div id="form" class=boxradius>
			<form id="account_regist_form" method="post" action="/C2/AccountRegistServlet">
			  <table>
			    <tr>
			      <td class=label>
					<label>UserID<br>
					<input type="text" name="user_ID" class=radius>
					</label>
			      </td>
			    </tr>
			    <tr>
			      <td class=label>
					<label>Mail<br>
					<input type="text" name="mail" class=radius>
					</label>
			      </td>
			    <tr>
			    <tr>
			      <td class=label>
					<label>Password<br>
					<input type="password" name="pw" class=radius>
					</label>
			      </td>
			    </tr>
			    <tr>
			      <td class=label>
					<label>Nicname<br>
					<input type="text" name="nickname" class=radius>
					</label>
			      </td>
			    <tr>
			    <tr>
			      <td>
					<input type="submit" name="submit" value="OK" class=okbutton>
			      <td>
			    </tr>
			  </table>
			</form>
		</div>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>
