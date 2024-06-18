'use strict';

//登録結果Windowアラート表示
        if('${result.title}' === '') {
        }
        else {
        	window.alert('${result.message}');
        }


/*
result.jsを使う時には以下のスクリプトをjspに追加してください
---------------------------------------------------------------
<script>

'use strict';

//登録結果Windowアラート表示
if('${result.title}' === '') {
}
else {
	window.alert('${result.message}');
}
*/
