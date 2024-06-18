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
			<img src=""><!-- アカウントのボタン -->
			<img src=""><!-- マニュアルのみ タスクボタン -->
			<img src="/C2/img/headerLogo.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
      <form method="post" action="/C2/ManualRegistServlet">
      	<table>
	        <tr><td>new manual<br></td></tr>
	        <tr><td>キッチン掃除<br></td></tr>

          <tr id = "target">
	          <td><input type="text" name="item" placeholder="項目"></td>
	          <td><input type="text" name="content" placeholder="内容"></td>
	          <td><input type="file" name="images"></td>
	          <td><button>-</button><br></td>
	        </tr>
        </table>
	      <input type="submit" id="regist" name="manual_regist" value="登録">
      </form>
			<button id = "add">+</button>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>

		<script>
		/*登録ボタンをクリックしたらwindowconfirmが出る処理*/
		var btn = document.getElementById('regist');

		btn.addEventListener('click', function() {

		    window.confirm('マニュアルを登録しますか？');

		})

		/*＋ボタンをクリックしたら列が増える処理*/
		function addExample() {
			let elements = document.getElementById("target");
			let copied = elements.cloneNode(true);
			elements.parentNode.appendChild(copied);
		}
		const btn2 = document.getElementById("add");
		btn2.addEventListener("click", addExample, false);

		</script>

		<script src="/C2/js/result.js"></script>

	</body>
</html>