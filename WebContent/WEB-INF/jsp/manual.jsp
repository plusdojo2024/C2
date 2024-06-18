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
      <a href="/C2/AccountServlet">accountUpdatePage</a>
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
      <p>Manual List</p>




      <form method="post" action="/C2/ManualServlet">
        <input type="search">
        <input type="submit" id="search" name="search" value="search">
        </form>



        <form action="#" class="search-form-3">
   			 <label>
        	<input type="text" placeholder="キーワードを入力">
    		</label>
    		<button type="submit" aria-label="検索"></button>
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