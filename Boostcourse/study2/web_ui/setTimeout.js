window.setTimeout()
setTimeout()

function run(){
    setTimeout(function(){
        var msg = "hello codesquad";
        console.log(msg);
    }), 1000;
}

run();

function run2(){
    console.log("start");
    setTimeout(function(){
        var msg = "hello codesquad";
        console.log(msg);
    },2000);
    console.log("end");
}

run();