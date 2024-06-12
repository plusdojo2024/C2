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
			<img src="/C2/img/headerLogo.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
		<h2>NEW GROUP</h2>
		<form id="" method="post" action="/C2/">
			<table>
			<tr>
			  <td>
			<input type="file" name="image">
			  </td>
			  <td>
			<input type="text" name="name" placeholder= "グループ名">
			  </td>
			</tr>
			<tr>
			  <td><input type="submit" value ="登録"></td>
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