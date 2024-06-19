<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet"  href="/C2/css/common.css">
		<link rel="stylesheet"  href="/C2/css/account_update.css">
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
			<a href="ManualServlet"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
			<h5 id = "time"></h5><!-- 時間 -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>


    	<main>
<!--      <c:if test="${empty accountList}">
				<p>一致するデータはありません。</p>
		  </c:if>-->
    	<c:forEach var="e" items="${accountList}" >
    	<div id="form" class=boxradius>
      		<form id="account_form" method="post" action="AccountServlet"><!--アクションにサーブレットを入力する-->
        		<table class="table">
          			<tr>
            			<td>
              				<label>User ID ※変更不可<br>
                				<input type="text" name="user_ID" value="${e.user_ID}" class=radius readonly="readonly">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Mail<br>
                				<input type="text" name="mail" value="${e.mail}" class=radius>
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Password<br>
                				<input type="text" name="password" class=radius placeholder="前のパスワードを入力">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>New Password<br>
                				<input type="text" name="newPassword" class=radius placeholder="新しいパスワードを入力">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Nickname<br>
                				<input type="text" name="nickname" value="${e.nickname}" class=radius>
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<input type="submit" id="register" name="submit" value="OK" class=okbutton>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label><br>
                				<input type="text" id="pw" name="pw" value="${e.pw}">
              				</label>
            			</td>
          			</tr>
        		</table>
     		</form>
     		</div>
     	  </c:forEach>
    	</main>


		<footer>
			<p class="copyright" id ="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
<script src="/C2/js/common.js"></script>
<script>
if('${result.title}' === '') {
}
else {
	window.alert('${result.message}');
}
</script>
	</body>
</html>

