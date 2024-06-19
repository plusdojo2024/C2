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
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
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