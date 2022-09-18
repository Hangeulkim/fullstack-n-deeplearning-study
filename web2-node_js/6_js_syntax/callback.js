/*
function a(){
    console.log('A');
}
a();
*/

var a = function (){
    console.log('A');
}//익명 함수


function slowfunc(callback){
    callback();
}

slowfunc(a);