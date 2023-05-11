// 공 넣기(10810)

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
        ball[i] = 0;
    }
    for(let i = 0; i < M; i++) {
        let ways = input[1 + i].split(' ').map((el) => parseInt(el));
        for(let j = ways[0]; j <= ways[1]; j++) {
            ball[j-1] = ways[2];
        }
    }

    let result = "";
    for(let i = 0; i < N; i++) {
        result += ball[i] + " ";
    }
    
    console.log(result);

    process.exit();
});