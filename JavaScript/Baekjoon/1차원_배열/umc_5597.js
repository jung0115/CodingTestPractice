// 과제 안 내신 분..?(5597)

const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input = [];

rl.on("line", function(line) {
    input.push(line)
}).on("close", function() {
    let students = [];
    for(let i = 0; i < 30; i++) {
        students[i] = true;
    }

    for(let i = 0; i < 28; i++) {
        let student = parseInt(input[i]);
        students[student - 1] = false;
    }

    for(let i = 0; i < 30; i++) {
        if(students[i]) console.log(i + 1);
    }

    process.exit();
});