// 합 (8393)

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
  const num = parseInt(input[0]);

  let sum = 0;
  for(let i = 1; i <= num; i++) {
    sum += i;
  }

  console.log(sum);
}