/**
 *
 */
'use strict';
function today() {
  let now = new Date();
  let hour = ("0" + now.getHours()).slice(-2);
  let min = ("0" + now.getMinutes()).slice(-2);
  let sec = ("0" + now.getSeconds()).slice(-2);
  document.getElementById('today').textContent = hour + ":" + min + ":" + sec + greeting ;

  refresh();
}
function refresh() {
    setTimeout(recalc, 1000);
}