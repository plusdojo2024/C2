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
			<form id ="update"><!--  -->
			<table>
			<tr>
			  <td><input type="file" name="image"></td>
			  <td><input type="text" name="name" value= "グループ1"></td>
			</tr>
			<tr>
			  <td><h2>MEMBER</h2></td>
			  <td><input type="text" value ="パパ"></td>
			  <td><button>-</button></td>
			  <td><input type="checkbox" class="agreement"></td>
			</tr>
			<tr>
			  <td><h2>MEMBER</h2></td>
			  <td><input type="text" value ="しんちゃん（閲覧モード）"></td>
			  <td><button>-</button></td>
			  <td><input type="checkbox" class="agreement"></td>
			</tr>
			<tr>
			  <td><h2>MEMBER</h2></td>
			  <td><input type="text" placeholder= "例：para_man"></td>
			  <td><button>-</button></td>
			  <td><input type="submit" value="招待"><td>
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
		<script src="/C2/js/group.js"></script>
	</body>
</html>