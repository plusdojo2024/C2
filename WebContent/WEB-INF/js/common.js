'use strict';

function recalc() {
  let now = new Date();
  let hour = ("0" + now.getHours()).slice(-2);
  let min = ("0" + now.getMinutes()).slice(-2);
  let sec = ("0" + now.getSeconds()).slice(-2);
  document.getElementById('time').textContent = hour + ":" + min + ":" + sec;

  refresh();
}
function refresh() {
    setTimeout(recalc, 1000);
}
recalc();