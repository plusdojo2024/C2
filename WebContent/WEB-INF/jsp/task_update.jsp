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

				<div style="position:relative; width:204px; height:141px; text-align:center;">
				<a href="/C2/GroupServlet" class="header-content">
						<img src="/C2/img/groupbutton.png" id="groupnamebutton">
						<span style="
							font-family:UD デジタル 教科書体 NK-B;
							font-size:12px;
							position:absolute;
							top:60px;
							display:block;
							height:100%;
							width:100%;
						">${group_name}
						</span>
				</a>
				</div>

				<div class="today-logo">
					<h5 id = "today" class="header-content"></h5><!-- 今日の日付 -->
				</div>
			</div>
		</header>
		<main>
			<div id="updatetasktitle">
            	<h1 id="updatetask">Task Detail</h1>
          	</div>
          	<div class="t-u-a">
	          	<div class="task-update-all">
		            <c:forEach var="e" items="${taskList}">
			            <form id="form" method="post" action="/C2/TaskUpdateServlet">
			            	<input type="hidden" name="id" value="${e.id}" >
							<div class="dayLine">
			           			<input type="date" id="day" name="deadline" value="${e.deadline}"><!-- 期限 -->
			                    	<input type="text" name="task" value="${e.task}">
			                    	<input type="checkbox" name="checkbox" class="check" style="accent-color: #7DE3A1;" value="yes"<c:if test="${e.checkbox}">checked</c:if>>

			                	</div>
			                	<div class="blocka">
									<textarea name="contents">${e.contents}</textarea>
									<div class="tofrom">
										&emsp;&emsp;To<input type="text" name="to" value="${e.to}">
			                      		&emsp;&emsp;From<input type="text" name="register" value="${e.register}">
			                		</div>
								</div>
				          		<!-- マニュアルリンク -->
				          		<div class="blockb">
					               	<select name="manual_id" >
					                   	<option label="　">0</option>
					     			    <c:forEach var="e" items="${manualList}">
					      	        		<option label="${e.manual_name}">${e.id}</option>
					          	  		</c:forEach>
					              	</select>
									<div class="formbox">

					                     <input type="submit" name="submit" value="OK" class="button1">
					                     <input type="submit" name="submit" value="Delete" class="button">
									</div>
								</div>
				            </form>
			            </c:forEach>

			            <!-- マニュアルボタン  -->
			            <div class="manual-link">
				            <form id="MB" method="post" action="/C2/ManualUpdateServlet">
				              <c:forEach var="e" items="${taskList}">
				              	<input type="hidden" name="id" value="${e.id}">
							  </c:forEach>
							  <c:forEach var="e" items="${taskList}">
								<input type="hidden"  id="manual_id" name="manual_id" value="${e.manual_id}">
								<input type="submit" value="${e.manual_link}" class="manual-link-button">
							  </c:forEach>
					        </form>
					     </div>
				        <p>
							<span id="error_message"></span>
						</p>
					</div>
				</div>
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
