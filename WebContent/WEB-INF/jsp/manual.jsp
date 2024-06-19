<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<div class="task-logo">
						<a href="/C2/TaskServlet" class="header-content"><img src="/C2/img/taskButton.png"></a><!-- マニュアルのみ タスクボタン -->
					</div>
					<h5></h5><!-- 空の枠 -->
					<div class="logo">
						<a href="/C2/ManualServlet" class="header-content"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
					</div>
					<h5></h5><!-- 空の枠 -->
					<h5></h5><!-- 空の枠 -->
					<div calss="today-logo">
						<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
					</div>
				</div>
			</header>
			<main>
	      <p class="manual">Manual</p>

			<form action="#" class="search-form">
	   			 <label>
	        	<input type="text" placeholder="検索">
	    		</label>
	    		<button type="submit"aria-label="検索"></button>
			</form>



	      <a href="/C2/ManualRegistServlet" class="plus-button"><img src="/C2/img/plusButton2.png" alt="＋ボタン"></a>


	      <c:forEach var="e" items="${cardList}" >
	      <table class="table">
	        <tr>
	          <td>
	            <input type="text" name="manual_name" value="${e.manual_name}" readonly="readonly">
	          </td>
	        </tr>
	       </table>
	      </c:forEach>
			</main>
			<footer>
				<p>&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
			</footer>
			<script src="/C2/js/common.js"></script>

	</body>
</html>