<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<img src="/C2/img/headerLogo2.png"><!-- ロゴ -->
			<h5 id = "today"></h5><!-- 今日の日付 -->
		</header>
		<main>
      <p>Details/Update/Delete</p>
      <form>
        <table>
					<tr>
          	<td>キッチン掃除<br></td>
          </tr>
          <tr>
            <td><input type="text" name="item" placeholder="項目"></td>
            <td><input type="text" name="content" placeholder="内容"></td>
            <td><input type="file" name="images"></td>
            <td><button>-</button><br></td>
          </tr>
          <tr>
            <td><input type="text" name="item" placeholder="項目"></td>
            <td><input type="text" name="content" placeholder="内容"></td>
            <td><input type="file" name="images" placeholder="画像"></td>
            <td><button>-</button><br></td>
          </tr>
          <tr>
            <td><button>+</button><br></td>
            <td>
            <input type="submit" id="" name="manual_update" value="OK">
            <input type="submit" id="delete" name="manual_delete" value="Delete">
            </td>
          </tr>
        </table>
      </form>
		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>