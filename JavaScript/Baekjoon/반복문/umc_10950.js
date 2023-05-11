// A+B - 3(10950)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
    //rl.close()가 없어서 계속 입력
    //로컬에서 입력을 중지하려면 입력을 한 후 ctrl+d로 입력 종료
}).on("close", function() {
    let T = parseInt(input[0]);

    for(let i = 0; i < T; i++) {
      let list = input[1 + i].split(' ').map((el) => parseInt(el));
      console.log(list[0] + list[1]);
    }

    process.exit();
});