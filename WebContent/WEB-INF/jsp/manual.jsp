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
				<div class="dropdown header-content">
					<button class="dropdown__btn" id="dropdown__btn" onClick="isOpen();">
						<div class ="account-logo"><img src="/C2/img/accountNull.png"></div><!-- アカウントロゴ -->
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
				<a href="/C2/TaskServlet" class="header-content"><img src="/C2/img/taskButton.png"></a><!-- マニュアルのみ タスクボタン -->
				<a href="/C2/TaskServlet" class="header-content"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
				<h5></h5><!-- 空の枠 -->
				<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
			</div>
		</header>
		<main>
      <p>Manual List</p>








        <form action="#" class="search-form">
   			 <label>
        	<input type="text" placeholder="検索">
    		</label>
    		<button type="submit"aria-label="検索"></button>
		</form>



      <a href="/C2/ManualRegistServlet"><img src="/C2/img/plusButton2.png" alt="＋ボタン"></a>


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