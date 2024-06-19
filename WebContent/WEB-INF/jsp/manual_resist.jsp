<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/manual.css">
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
				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>

		<main>
			<div id="newmanualtitle">
				<p id="newmanual">New Manual</p>
			</div>
			<div id="form" class=boxradius>
      			<form method="post" action="/C2/ManualRegistServlet">
      				<table>
	        			<tr>
	        			  <td>
	        				<input type="text" name="title" placeholder="マニュアル名"><br>
	        			  </td>
	        			</tr>
						<tr id = "target">
	          			  <td>
	          				<input type="text" name="item" placeholder="項目">
	          			  </td>
	          			  <td>
	          			    <input type="text" name="content" placeholder="内容">
	          			  </td>
	          			  <td>
	          			    <input type="file" name="images">
	          			  </td>
	          			  <td>
	          			    <img src="/C2/img/minusButton3.png" onclick="deleteExample(this);"><br>
	          			  </td>
	       			    </tr>
       				 </table>
					<img src="/C2/img/plusButton2.png" id = "add" onclick="addExample();">
					<input type="submit" id="regist" name="manual_regist" value="OK" onclick="checkMessage();" class=okbutton>
     	 		</form>
     	 	</div>
		</main>

		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script src="/C2/js/manual.js"></script>
		<!--  <script src="/C2/js/result.js"></script>-->

		<script>
        if('${result.title}' === '') {
        }
        else {
        	window.alert('${result.message}');
        }
		</script>

		</body>
</html>