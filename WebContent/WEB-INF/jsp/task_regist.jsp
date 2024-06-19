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
            <h1>new task</h1>
            <form method="post" action="/C2/TaskServletRegist">
                <table>
                    <tr>
                        <td><input type="date" id="day" name="day"></td><!-- 期限 -->
                        <td><input type="text" name="task"placeholder="見出し"></td>
                        <td><input type="checkbox" name="checkbox"></td>
                    </tr>
                    <tr>
                        <td><textarea name="content">タスク内容</textarea></td>
                        <td><a href="">マニュアルボタン</a></td>
                        <td><select name="manual_link">
                            <option>manual1</option>
                            <option>manual2</option>
                            <option>manual3</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="to"placeholder="to"></td>
                        <td><input type="text" name="register"></td>
                        <td><input type="submit" value="登録"></td>
                    </tr>
                </table>
            </form>
            </main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
		<script type="text/javascript">
        //今日の日時を取得
        window.onload = function () {
            var date = new Date()
            var year = date.getFullYear()
            var month = date.getMonth() + 1
            var day = date.getDate()

            var toTwoDigits = function (num, digit) {
              num += ''
              if (num.length < digit) {
                num = '0' + num
              }
              return num
            }

            var yyyy = toTwoDigits(year, 4)
            var mm = toTwoDigits(month, 2)
            var dd = toTwoDigits(day, 2)
            var ymd = yyyy + "-" + mm + "-" + dd;

            document.getElementById("day").value = ymd;
        }
		</script>
	</body>
</html>