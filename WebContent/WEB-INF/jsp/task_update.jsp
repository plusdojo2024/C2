<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>famiLink</title>
		<link rel="stylesheet" href="/C2/css/common.css">
		<link rel="stylesheet" href="/C2/css/task_update.css">
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
				<h5></h5><!-- 空の枠 -->
				<h5></h5><!-- 空の枠 -->
				<div class="logo">
					<a href="/C2/ManualServlet" class="header-content"><img src="/C2/img/headerLogo2.png"></a><!-- ロゴ -->
				</div>
				<h5></h5><!-- 空の枠 -->
				<h5>${group_name}</h5><!-- 空の枠 -->
				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>
		<main>
		  <div id="updatetasktitle">
            <h1 id="updatetask">task detail</h1>
          </div>
            <c:forEach var="e" items="${taskList}">
            <form id="form" method="post" action="/C2/TaskUpdateServlet">
            	<input type="hidden" name="id" value="${e.id}" >
   					  <div class="dayLine">
                <table>
                    <tr>

                        <td><input type="date" id="day" name="deadline" value="${e.deadline}"></td><!-- 期限 -->
                        <td><input type="text" name="task" value="${e.task}"></td>
                        <td><input type="checkbox" name="checkbox" value="yes"<c:if test="${e.checkbox}">checked</c:if>></td>

                    </tr>
                    </div>
                    <tr>
                        <td><textarea name="contents">${e.contents}</textarea></td>
                    </tr>
                    <tr>
                        <td>To<input type="text" name="to" value="${e.to}"></td>
                        <td>From<input type="text" name="register" value="${e.register}"></td>
                    </tr>
                </table>
            	<!-- マニュアルリンク -->
                	<select name="manual_id" >
                    	<option label="　">0</option>
                      <c:forEach var="e" items="${manualList}">
                        <option label="${e.manual_name}">${e.id}</option>
                	  </c:forEach>
               	    </select>
					  <div class="formbox">
                        <input type="submit" name="submit" value="更新">
                        <input type="submit" name="submit" value="削除">
					  </div>
            </form>
            </c:forEach>
            <!-- マニュアルボタン  -->
            <form id="MB" method="post" action="/C2/ManualUpdateServlet">
              <c:forEach var="e" items="${taskList}">
              	<input type="hidden" name="id" value="${e.id}">
			  </c:forEach>
			  <c:forEach var="e" items="${taskList}">
				<input type="hidden"  id="manual_id" name="manual_id" value="${e.manual_id}">
				<input type="submit" value="${e.manual_link}">
			  </c:forEach>
	        </form>
	        <p>
				<span id="error_message"></span>
			</p>
    		</main>
		<footer>
			<p class="copyright">&copy; paraparaChahan(PLUS DOJO).ALL rights reserved.</p><!-- コピーライト -->
		</footer>
	<script src="/C2/js/common.js"></script>
	<script>
	'use strict';
	//登録結果Windowアラート表示
		if('${result}' === '') {
		}
		else {
			window.alert('${result}');
		}
	</script>
	<script>
	'use strict';

	 /* HTML要素をオブジェクトとして取得する */
	 	let formObj = document.getElementById('MB');
		let errorMessageObj = document.getElementById('error_message');

	 /* [ログイン]ボタンをクリックしたときの処理 */
		formObj.onsubmit = function() {
	 	 if (formObj.manual_id.value == 0) {
	   	 return false;
	  	}
	 	 errorMessageObj.textContent = null;
		};
	</script>
	</body>
</html>
