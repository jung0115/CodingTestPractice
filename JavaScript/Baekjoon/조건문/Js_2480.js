// 백준 - 조건문 - 주사위 세개(2480)

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
  const dice1 = parseInt(input[0]);
  const dice2 = parseInt(input[1]);
  const dice3 = parseInt(input[2]);

  let price = 0;
  
  // 같은 눈이 3개가 나오는 경우
  if(dice1 === dice2 && dice1 === dice3) {
    price = 10000 + dice1 * 1000;
  }

  // 같은 눈이 2개만 나오는 경우
  else if(dice1 === dice2 || dice1 === dice3) {
    price = 1000 + dice1 * 100;
  }
  else if(dice2 === dice3) {
    price = 1000 + dice2 * 100;
  }

  // 모두 다른 눈이 나오는 경우
  else {
    let max = dice1;
    if(max < dice2) max = dice2;
    if(max < dice3) max = dice3;

    price = max * 100;
  }

  console.log(price);
};