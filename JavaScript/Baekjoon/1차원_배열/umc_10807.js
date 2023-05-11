// 개수 세기(10807)

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
    let nums = input[1].split(' ').map((el) => parseInt(el));
    let v = parseInt(input[2]);

    let cnt = 0;
    for(let i = 0; i < N; i++) {
      if(nums[i] === v) cnt++;
    }
    
    console.log(cnt);

    process.exit();
});