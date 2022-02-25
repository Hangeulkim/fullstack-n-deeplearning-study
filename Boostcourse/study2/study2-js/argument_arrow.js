function a(){
    console.log(arguments);
}
a(1,2,3);

function getName(name){
    return "Kim" + name;
}

var getName = (name) => "Kim " + name;