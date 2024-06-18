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
			<div class="dropdown">
				<button class="dropdown__btn" id="dropdown__btn" onClick="isOpen();">
					<img src="/C2/img/accountNull.png">
			    </button>
				<div class="dropdown__body" id="dropdown__body">
	    			<ul class="dropdown__list">
	      				<li class="dropdown__item"><a href="/C2/AccountServlet" class="dropdown__item-link">アカウント画面</a></li>
	      				<li class="dropdown__item"><a href="/C2/GroupServlet" class="dropdown__item-link">グループ一覧</a></li>
	      				<li class="dropdown__item"><a href="/C2/GroupUpdateServlet" class="dropdown__item-link">グループ詳細</a></li>
	      				<li class="dropdown__item"><a href="/C2/LogoutServlet" class="dropdown__item-link">ログアウト</a></li>
				    </ul>
				</div>
			</div>
			<a href="/C2/TaskServlet"><img src="/C2/img/taskButton.png"></a><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
      <p>Manual List</p>
      <form method="post" action="/C2/ManualServlet">
        <input type="search">
        <input type="submit" id="search" name="search" value="search">
      </form>
      <a href="/C2/ManualRegistServlet">+</a>


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
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>