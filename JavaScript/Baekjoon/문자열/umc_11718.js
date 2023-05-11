// 그대로 출력하기 (11718)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
  for(let i = 0; i < input.length; i++) {
    let S = input[i];
    console.log(S);
  }

  process.exit();
});