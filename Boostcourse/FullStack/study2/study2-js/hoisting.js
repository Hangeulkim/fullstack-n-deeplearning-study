function pinrtName(firstname){
    var myname = "hangeul";
    return myname +" "+firstname;
}

function test(){
    console.log(printName());
    var printName = function(){
        return 'anonymouse';
    }
}
test();

printName();
var printName = function(){};