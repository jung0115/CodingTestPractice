/*
문자열로 이루어진 배열이 주어졌을 때
배열에 있는 모든 문자열을 대문자로 바꾸어 반환하는 함수를 작성
단, map 메서드를 사용하지 않고 for 루프를 사용하여 작성
*/

const language = ["Java", "javaScript", "python", "kotlin"];
const languageUpper = arrayToUpper(language);
console.log(languageUpper);

function arrayToUpper(arr) {
  const arrUpper = [];
  for (let i = 0; i < arr.length; i++) {
    // 대문자로 변환
    arrUpper.push(arr[i].toUpperCase());
  }
  return arrUpper;
}