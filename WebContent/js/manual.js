/**
 *

 */

/*マニュアル項目追加ボタンを押したら項目が増える*/
/*要素をコピー＆追加する関数*/
function addExample() {
		let elements = document.getElementById("target");
        let copied = elements.lastElementChild.cloneNode(true);
        elements.appendChild(copied);
}

/* ボタンにイベントハンドラをセット*/
const btn = document.getElementById("add");
btn.addEventListener("click", addExample, false);
