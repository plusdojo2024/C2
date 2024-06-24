/**
 *
 */
'use strict';


//日付表示
function today(){
	   let today = new Date();
	   let year = today.getFullYear();
	   let month = today.getMonth()+1;
	   let date =  today.getDate();
	   let youbi = today.getDay();
	   let day;
	   switch(youbi){
	   case 0:
		   day = "Sun";
		   break;
       case 1:
	       day = "Mon";
	       break;
	   case 2:
		   day = "Tue";
		   break;
	   case 3:
		   day = "Wen";
		   break;
	   case 4:
		   day = "Thu";
		   break;
	   case 5:
		   day = "Fri";
		   break;
	   case 6:
		   day = "Sat";
		   break;
	   }

	    document.getElementById('today').textContent = year + "/" + month + "/" + date + "（" + day + "）";

	    refresh();
	}
function refresh() {
    setTimeout(recalc, 1000);
}
today();



  function isOpen(){ //ボタンがクリックされたら
	let body = document.getElementById('dropdown__btn');
	body.classList.toggle('is-open'); // is-openを付加する


	//this.classList.toggle('is-open'); // is-openを付加する
  }