// 공 바꾸기(10813)

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
    let N = list[0];
    let M = list[1];

    let ball = [];
    for(let i = 0; i < N; i++) {
        ball[i] = i + 1;
    }
    for(let i = 0; i < M; i++) {
        let ways = input[1 + i].split(' ').map((el) => parseInt(el));
        let temp = ball[ways[0] - 1];
        ball[ways[0] - 1] = ball[ways[1] - 1];
        ball[ways[1] - 1] = temp;
    }

    let result = "";
    for(let i = 0; i < N; i++) {
        result += ball[i] + " ";
    }
    
    console.log(result);

    process.exit();
});