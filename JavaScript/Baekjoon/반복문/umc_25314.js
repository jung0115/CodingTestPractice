// 코딩은 체육과목 입니다 (25314)

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
  const byte = parseInt(input[0]);

  let count = byte/4;
  let result = "";
  for(let i = 0; i < count; i++) {
    result += "long ";
  }
  result += "int";

  console.log(result);
}