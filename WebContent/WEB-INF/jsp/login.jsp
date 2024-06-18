<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/login.css">
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
			<form id="login_form" method="post" action="/C2/LoginServlet">
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
					<label>Password<br>
					<input type="password" name="pw" class=radius>
					</label>
			      </td>
			    <tr>
			    <tr>
			      <td colspan="2">
					<input type="submit" name="submit" value="OK" class=loginbutton>
					<input type="reset" name="reset" value="Reset" class=loginbutton>
					<p>
					<span id="error_message"></span>
					</p>
			      <td>
			    </tr>
			  </table>

			<a href="/C2/AccountRegistServlet">Create account</a>

			</form>
			</div>
		</main>

		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
		<script src="/C2/js/login.js"></script>
		<script src="/C2/js/result.js"></script>
	</body>
</html>

