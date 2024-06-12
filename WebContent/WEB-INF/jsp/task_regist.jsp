<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
	</head>
	<body>
		<header>
			<img src=""><!-- アカウントのボタン -->
			<img src="/C2/img/headerLogo.png"><!-- ロゴ -->
			<h5 id = "today">今日の日付</h5><!-- 今日の日付 -->
		</header>
		<main>
            <h1>new task</h1>
            <form method="post" action="/C2/RegistServlet">
                <table>
                    <tr>
                        <td>日付<input type="date"></td>
                        <td><input type="text" placeholder="見出し"></td>
                    </tr>
                    <tr>
                        <td><textarea>タスク内容</textarea></td>
                        <td><a href="">マニュアルボタン</a></td>
                        <td><select name="manual">
                            <option>manual1</option>
                            <option>manual2</option>
                            <option>manual3</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="to"></td>
                        <td>from ママ</td>
                        <td><input type="submit" value="登録"></td>
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