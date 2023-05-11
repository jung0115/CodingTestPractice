// 시험 성적(9498)

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
  const score = parseInt(input[0]);

  if(score >= 90) console.log("A");
  else if(score >= 80) console.log("B");
  else if(score >= 70) console.log("C");
  else if(score >= 60) console.log("D");
  else console.log("F");
};