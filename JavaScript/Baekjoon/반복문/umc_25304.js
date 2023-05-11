// 영수증(25304)

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
    let X = parseInt(input[0]);
    let N = parseInt(input[1]);

    let price = 0;
    for(let i = 0; i < N; i++) {
      let list = input[2 + i].split(' ').map((el) => parseInt(el));
      price += list[0] * list[1];
    }
    
    if(X === price) console.log("Yes");
    else console.log("No");

    process.exit();
});