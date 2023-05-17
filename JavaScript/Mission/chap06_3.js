/*
사용자로부터 입력받은 수를 0으로 나누는 코드를 작성
이때, 0으로 나누려는 경우 "Cannot divide by zero"라는 메시지를 출력
그 외의 경우에는 나눈 값을 출력
*/

const input = prompt("정수를 입력하세요");

try {
  const divide = input / 0;
  console.log("나눈 값: " + divide);
} catch (error) {
  console.log("Cannot divide by zero");
}