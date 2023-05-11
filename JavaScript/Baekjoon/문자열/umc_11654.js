// 아스키 코드(11654)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
  let S = input[0];

  console.log(S.charCodeAt());

  process.exit();
});