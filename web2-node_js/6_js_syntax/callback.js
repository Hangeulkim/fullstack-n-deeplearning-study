/*
function a(){
    console.log('A');
}
a();
*/

var a = function (){
    console.log('A');
}//�͸� �Լ�


function slowfunc(callback){
    callback();
}

slowfunc(a);