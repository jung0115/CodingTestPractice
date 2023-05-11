// 행렬 덧셈(2738)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
  let list = input[0].split(' ').map((el) => parseInt(el));
  let N = parseInt(list[0]);
  let M = parseInt(list[1]);
  
  let A = [];
  for(let i = 0; i < N; i++) {
    list = input[1 + i].split(' ').map((el) => parseInt(el));
    A[i] = [];
    for(let j = 0; j < M; j++) {
      A[i][j] = list[j];
    }
  }

  let B = [];
  for(let i = 0; i < N; i++) {
    list = input[1 + N + i].split(' ').map((el) => parseInt(el));
    B[i] = [];
    for(let j = 0; j < M; j++) {
      B[i][j] = list[j];
    }
  }

  for(let i = 0; i < N; i++) {
    let line = "";
    for(let j = 0; j < M; j++) {
      let sum = A[i][j] + B[i][j];
      line += sum.toString() + " ";
    }
    console.log(line);
  }

  process.exit();
});