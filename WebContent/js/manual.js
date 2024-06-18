/**
 *

 */

'use strict';
/*マニュアルの登録画面と詳細画面→－ボタンをクリックしたら列が消える処理*/
function deleteExample(obj) {
    // 削除ボタンを押下された行を取得
    let tr = obj.parentNode.parentNode;
	tr.remove();
}

/*＋ボタンをクリックしたら列が増える処理*/
function addExample() {
	let elements = document.getElementById("target");
	let copied = elements.cloneNode(true);
	elements.parentNode.appendChild(copied);
}

/*マニュアルの登録画面と詳細画面→登録やokをクリックしたらwindowconfirmが出る処理*/
function checkMessage() {
	window.confirm('マニュアルを登録しますか？');
}

/*マニュアルの登録画面と詳細画面→＋ボタンをクリックしたら列が増える処理*/
function addExample() {
	let elements = document.getElementById("target");
	let copied = elements.cloneNode(true);
	elements.parentNode.appendChild(copied);
}

/*詳細画面→deleteをクリックしたらwindowconfirmが出る処理 */
function manualDelete(){
	window.confirm('マニュアルを削除しますか？');
}
