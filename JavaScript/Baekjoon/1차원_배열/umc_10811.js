// 바구니 뒤집기(10811)

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

    let baskets = [];
    for(let i = 1; i <= N; i++) {
        baskets[i] = i;
    }
    for(let i = 0; i < M; i++) {
        let ways = input[1 + i].split(' ').map((el) => parseInt(el));
        let end = (ways[1] - ways[0]) / 2;
        for(let j = 0; j <= end; j++) {
            let temp = baskets[ways[0] + j];
            baskets[ways[0] + j] = baskets[ways[1] - j];
            baskets[ways[1] - j] = temp;
        }
    }

    let result = "";
    for(let i = 1; i <= N; i++) {
        result += baskets[i] + " ";
    }
    
    console.log(result);
});