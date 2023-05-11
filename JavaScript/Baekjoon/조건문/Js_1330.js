// 백준 - 조건문 - 두 수 비교하기(1330)

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline.on('line', function(line) {
  input = line.split(' ').map(el => parseInt(el));
}).on('close', function(){
  solution(input);
  process.exit();
});

const solution = input => {
  const num1 = parseInt(input[0]);
  const num2 = parseInt(input[1]);

  if(num1 > num2) console.log(">");
  else if(num1 < num2) console.log("<");
  else console.log("==");
};