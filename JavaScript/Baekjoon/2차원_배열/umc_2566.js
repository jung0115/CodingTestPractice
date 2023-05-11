// 최댓값(2566)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
  let max = 0;
  let x = 0, y = 0;

  let nums = [];
  for(let i = 0; i < 9; i++) {
    list = input[i].split(' ').map((el) => parseInt(el));
    nums[i] = [];
    for(let j = 0; j < 9; j++) {
      nums[i][j] = list[j];
      if(max <= nums[i][j]) {
        max = nums[i][j];
        x = i+1;
        y = j+1;
      }
    }
  }

  console.log(max);
  console.log(x + " " + y);

  process.exit();
});