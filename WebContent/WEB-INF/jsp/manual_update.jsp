<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
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
						<li class="gnavi__list"><a href="#"><img
								src="/C2/img/accountNull.png"></a>
							<ul class="dropdown__lists">
								<li class="dropdown__list"><a href="/C2/AccountServlet">アカウント画面</a></li>
								<li class="dropdown__list"><a href="/C2/GroupServlet">グループ一覧</a></li>
								<li class="dropdown__list"><a href="/C2/GroupUpdateServlet">グループ詳細</a></li>
								<li class="dropdown__list"><a href="/C2/LogoutServlet">ログアウト</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<h5></h5>
			<!-- 空の枠 -->
			<h5></h5>
			<!-- 空の枠 -->
			<div class="logo">
				<a href="/C2/ManualServlet" class="header-content"><img
					src="/C2/img/headerLogo2.png"></a>
				<!-- ロゴ -->
			</div>
			<h5></h5>
			<!-- 空の枠 -->
			<h5></h5>
			<!-- 空の枠 -->
			<div class="today-logo">
				<h5 id="today" class="header-content"></h5>
				<!-- 今日の日付 -->
			</div>
		</div>
	</header>
	<main>
		<p>ManualDetails</p>
		<form method="post" action="/C2/ManualUpdateServlet">
			<c:forEach var="e" items="${itemList}">
				<table>
					<tr>
						<td><input type="hidden" name="manual_id" value="${e.manual_id}"></td>
					</tr>
					<tr>
						<td><input type="text" name="heading" value="${e.esc}"
							class="heading"></td>
					</tr>
					<tr id="target">
						<td><input type="text" name="item" value="${e.heading}"
							class="items"></td>
						<td><input type="text" name="content" value="${e.contents}"
							class="contents"></td>
						<td><input type="file" name="images" value="${e.image}"
							class="images"></td>
						<td><button onclick="deleteExample(this);">-</button> <br></td>
					</tr>
				</table>
			</c:forEach>
			<input type="submit" id="ok" name="manual_update" value="OK"
				onclick="checkMessage();"> <input type="submit" id="delete"
				name="manual_delete" value="Delete" onclick="manualDelete();">

		</form>


		<button id="add" onclick="addExample();">+</button>
	</main>
	<footer>
		<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights
			reserved.</p>
		<!-- コピーライト -->
	</footer>

	<script src="/C2/js/common.js"></script>
	<script src="/C2/js/manual.js"></script>
</body>
</html>