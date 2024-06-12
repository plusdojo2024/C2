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
			<img src="/C2/img/headerLogo.png"><!-- ロゴ -->
			<h5 id = "today">今日の日付</h5><!-- 今日の日付 -->
		</header>
		<main>
            <form method="post" action="/C2/TaskServlet">
                <p>日付<input type="date"><input type="text" placeholder="検索"><input type="submit" name="search" value="検索"></p>
            </form>
                <ui>
                    <li><input type="checkbox" name="detail">燃えるゴミ出し</li>
                    <li><input type="checkbox" name="detail">燃えないゴミ出し</li>
                    <li><a href="/C2/TaskRegistServlet"><button>+</button></a></li>
                </ui>
                <ui>
                    <li>schedule</li>
                    <li>09:00 授業参観</li>
                    <li>19:00 夜ごはん</li>
                    <li><a href="/C2/TaskRegistServlet"><button>+</button></a></li>
                </ui>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>