/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function shownewdate() {
    var date = new Date();
    var year = date.getFullYear().toString();
    var month = (date.getMonth()+1).toString();
    if (month.length == 1) month = "0" + month;
    var day = date.getDate().toString();
    if (day.length == 1) day = "0" + day;
    var datecurrent = parseInt(year + month + day);
    var DateVer = document.getElementsByClassName("DatumVer");
    var EntryDateVer = 0;
    for (var i = 0; i < DateVer.length; i++) {
        if (parseInt(DateVer[i].title) < datecurrent || EntryDateVer >= 3) {
            DateVer[i].style.display = "none";
        }
        else EntryDateVer++;
    }
    var DateErw = document.getElementsByClassName("DatumErw");
    var EntryDateErw = 0;
    for (var i = 0; i < DateErw.length; i++) {
        if (parseInt(DateErw[i].title) < datecurrent || EntryDateErw >= 3) {
            DateErw[i].style.display = "none";
        }
        else EntryDateErw++;
    }
    var DateJug = document.getElementsByClassName("DatumJug");
    var EntryDateJug = 0;
    for (var i = 0; i < DateJug.length; i++) {
        if (parseInt(DateJug[i].title) < datecurrent || EntryDateJug >= 3) {
            DateJug[i].style.display = "none";
        }
        else EntryDateJug++;
    }
}