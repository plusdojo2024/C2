<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet"  href="/C2/css/common.css">
	</head>

	<body>
		<header>
			<div class="dropdown">
				<button class="dropdown__btn" id="dropdown__btn">
					<img src="/C2/img/accountNull.png">
			    </button>
			<div class="dropdown__body">
    			<ul class="dropdown__list">
      				<li class="dropdown__item"><a href="https://www.google.com/" class="dropdown__item-link">アカウント画面</a></li>
      				<li class="dropdown__item"><a href="https://www.yahoo.co.jp/" class="dropdown__item-link">グループ一覧</a></li>
      				<li class="dropdown__item"><a href="https://www.bing.com/" class="dropdown__item-link">グループ詳細</a></li>
			    </ul>
			</div>
			</div>
			<a href="ManualServlet"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
			<h5 id = "time"></h5><!-- 時間 -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>


    	<main>
    	<p>アカウント情報</p>
    	  <c:if test="${empty accountList}">
				<p>一致するデータはありません。</p>
		  </c:if>
    	<c:forEach var="e" items="${accountList}" >
      		<form id="account_form" method="post" action="AccountServlet"><!--アクションにサーブレットを入力する-->
        		<table class="table">
          			<tr>
            			<td>
              				<label>User ID<br>
                				<input type="text" name="user_ID" value="${e.user_ID}">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Mail<br>
                				<input type="text" name="mail" value="${e.mail}">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Password<br>
                				<input type="text" name="password" value="${e.pw}">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>New Password<br>
                				<input type="text" name="newPassword">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<label>Nickname<br>
                				<input type="text" name="nickname" value="${e.nickname}">
              				</label>
            			</td>
          			</tr>
          			<tr>
            			<td>
              				<input type="submit" id="register" name="submit" value="登録">
            			</td>
          			</tr>
        		</table>
     		</form>
     	  </c:forEach>
    	</main>


		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script src="/C2/js/common.js"></script>
<script>//日付表示
function today(){
	   let today = new Date();
	   let year = today.getFullYear();
	   let month = today.getMonth()+1;
	   let date =  today.getDate();
	   let youbi = today.getDay();
	   let day;
	   switch(youbi){
	   case 0:
		   day = "Sun";
		   break;
       case 1:
	       day = "Mon";
	       break;
	   case 2:
		   day = "Tue";
		   break;
	   case 3:
		   day = "Wen";
		   break;
	   case 4:
		   day = "Thu";
		   break;
	   case 5:
		   day = "Fri";
		   break;
	   case 6:
		   day = "Sat";
		   break;
	   }

	    document.getElementById('today').textContent = year + "/" + month + "/" + date + "/" + "（" + day + "）";

	    refresh();
	}
function refresh() {
    setTimeout(recalc, 1000);
}
today();
</script>
<script>//左上のアカウントボタン
(function () {
	  document.addEventListener('DOMContentLoaded', function() { // HTML解析が終わったら
	    const btn = document.getElementById('dropdown__btn'); // ボタンをidで取得
	    if(btn) { // ボタンが存在しないときにエラーになるのを回避
	      btn.addEventListener('click', function(){ //ボタンがクリックされたら
	        this.classList.toggle('is-open'); // is-openを付加する
	      });
	    }
	  });
	}());
</script>
	</body>
</html>

