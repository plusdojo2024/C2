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
			<div class="header-contents">
				<div class="header-content">
					<div class="gnavi__wrap">
						 <ul class="gnavi__lists">
							 <li class="gnavi__list">
						     	<a href="#"><img src="/C2/img/accountNull.png"></a>
						        <ul class="dropdown__lists">
						       		<li class="dropdown__list"><a href="/C2/AccountServlet">アカウント画面</a></li>
							       	<li class="dropdown__list"><a href="/C2/GroupServlet">グループ一覧</a></li>
							       	<li class="dropdown__list"><a href="/C2/GroupUpdateServlet">グループ詳細</a></li>
							       	<li class="dropdown__list"><a href="/C2/LogoutServlet">ログアウト</a></li>
						        </ul>
							</li>
						</ul>
					</div>
				</div>
				<h5></h5><!-- 空の枠 -->
				<h5></h5><!-- 空の枠 -->
				<div class="logo">
					<a href="/C2/ManualServlet" class="header-content"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
				</div>
				<h5></h5><!-- 空の枠 -->
				<h5>${group_name}</h5><!-- 空の枠 -->
				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>
		<main>
		<h2>NEW GROUP</h2>
		<form id="createGroup" method="post" action="/C2/GroupCreateServlet">
			<table>
			<tr>
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