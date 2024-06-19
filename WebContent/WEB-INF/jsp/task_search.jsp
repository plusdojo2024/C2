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
            <form method="post" action="/C2/TaskServlet">
                <p>日付<input type="date"><input type="text" placeholder="検索"><input type="submit" name="search" value="検索"></p>
                    <ul>
                        <li><input type="checkbox" name="detail">燃えるゴミ出し</li>
                        <li><input type="checkbox" name="detail">燃えないゴミ出し</li>
                    	<li><a href="/C2/TaskServletRegist"><button>+</button></a></li>
                    </ul>
                    <ul>
                        <li>schedule</li>
                        <li>09:00 授業参観</li>
                        <li>19:00 夜ごはん</li>
                    	<li><a href="/C2/ScheduleRegistServlet"><button>+</button></a></li>
                    </ul>
            </form>
                </main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
		<script src="/C2/js/common.js"></script>
	</body>
</html>