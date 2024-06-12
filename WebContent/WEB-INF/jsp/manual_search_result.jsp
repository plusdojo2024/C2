<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
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
      <p>Manual List</p>
      <form method="post" action="/C2/ManuelUpdateServlet">
        <input type="search">
        <input type="submit" id="search" name="search" value="search">
      </form>
      <a href="/C2/ManuelRegistServlrt">+</a>
      <table>
        <tr><th>お風呂掃除</th></tr>
        <tr><th>洗濯</th></tr>
        <tr><th>棚の整理</th></tr>
      </table>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>