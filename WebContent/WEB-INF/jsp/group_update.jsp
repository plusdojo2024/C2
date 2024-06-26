<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>famiLink</title>
<link rel="stylesheet" href="/C2/css/common.css">
<link rel="stylesheet" href="/C2/css/group_update.css">
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
			<h5></h5><!-- 空の枠 -->

				<div style="position:relative; width:204px; height:141px; text-align:center;">
				<a href="/C2/GroupServlet" class="header-content">
						<img src="/C2/img/groupbutton.png" id="groupnamebutton">
						<span style="
							font-family:UD デジタル 教科書体 NK-B;
							font-size:12px;
							position:absolute;
							top:60px;
							display:block;
							height:100%;
							width:100%;
						">${group_name}
						</span>
				</a>
				</div>

			<div class="today-logo">
				<h5 id="today" class="header-content"></h5>
				<!-- 今日の日付 -->
			</div>
		</div>
	</header>

	<main>
	<div id="form" class=boxradius>
		<form id="update" method="post" action="/C2/GroupUpdateServlet">
			<!--  -->
			<table>
				<c:forEach var="e" items="${GroupsList}" begin="0" end="0">
					<tr>
						<!--  <td><input type="file" name="image" class="gicon"></td> -->
						<td><input type="text" name="group_name"
							value="${e.group_name}" class="gName"></td>
					</tr>
				</c:forEach>
				<c:forEach var="e" items="${GroupsList}">
					<tr>
						<td><h2>MEMBER</h2></td>
						<td><input type="text" value="${e.user_ID}" class="member" name="delete"></td>
						<!-- <td><button onclick="deleteExample(this);">-</button></td> -->
					</tr>
				</c:forEach>
				<tr>
					<td><h2>MEMBER</h2></td>
					<td><input type="text" placeholder="例：para_man"
						class="newMember" name="invite"></td>
					<td><input type="submit" name="submit" value="Invitation"></td>
				</tr>
				<tr>
					<td>
					<div id="okbutton">
					<input type="submit" name="submit" value="OK" class=okbutton>
					</div>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</main>
	<footer>
		<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights
			reserved.</p>
		<!-- コピーライト -->
	</footer>
	<script src="/C2/js/common.js"></script>
	<script src="/C2/js/group.js"></script>
</body>
</html>