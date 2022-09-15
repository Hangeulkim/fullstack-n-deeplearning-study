var name = 'abcd';
var letter = 'dear ' + name+ '\n\
\
asdfasdfasdfasdfasdfasdfasdfasdfasdfsadf\n\n'
console.log(letter);

var a = '1';

var letter2 = `Dear ${name} ${'1'+'1'}
asdfasdfasdfasdfasdfasdfasdfasdfasdfsadf.${1+1}
${name}`;

console.log(letter2);