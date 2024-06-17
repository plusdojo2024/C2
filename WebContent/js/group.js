'use strict';
let formObj = document.getElementById('update');

/* [登録]ボタンをクリックしたときの処理 */
formObj.onsubmit = function() {
  /* チェックボックスを必須とします */
if (document.getElementByClassName("agreement").checked) {
    // チェックボックスがONのときの処理
	window.alert('更新しました。');
  } else {
    /*チェックボックスがOFFのときの処理*/
	window.alert('※必ず一人は権限者を設定してください！');
	return false;
  }


}