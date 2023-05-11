// 문자열(9086)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
  let N = parseInt(input[0]);
  
  for(let i = 1; i <= N; i++) {
    let S = input[i];
    console.log(S[0] + S[S.length - 1]);
  }

  process.exit();
});