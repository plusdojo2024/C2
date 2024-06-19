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
		<h2>NEW GROUP</h2>
		<form id="createGroup" method="post" action="/C2/GroupCreateServlet">
			<table>
			<tr>
			  <td>
			<input type="file" name="icon">
			  </td>
			  <td>
			<input type="text" name="group_name" placeholder= "グループ名">
			  </td>
			</tr>
			<tr>
			  <td><input type="submit" value ="登録"></td>
			</tr>

			</table>
			<span id="error_message"></span>
		</form>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>

	<script>

	/* HTML要素をオブジェクトとして取得する */
	let formObj = document.getElementById('createGroup');
	let errorMessageObj = document.getElementById('error_message');


	/* [実行]ボタンをクリックしたときの処理 */
	formObj.onsubmit = function() {

	  /* グループ名を必須入力項目とします */
	  if (!formObj.group_name.value) {
	    errorMessageObj.textContent = '※グループ名を入力してください！';
	    return false;
	  }
	  errorMessageObj.textContent = null;
	};
	</script>
	</body>
</html>