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
			<div class="header-contents">
				<h5></h5><!-- 空の枠 -->
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
		  <div id=house>
		  <img src="/C2/img/registComplete2.png"><!-- 家のロゴ -->
		  <h2 class=housetext>Welcome!!</h2>
		  <h1 class=housetext>アカウントの登録が完了しました</h1>
		  <p><a href="/C2/LoginServlet">ログイン画面へ</a></p>
		  </div>

		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>
