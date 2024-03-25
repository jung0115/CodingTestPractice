// 프로그래머스 - 괄호 회전하기(Lv.2)
function solution(s) {
  var answer = 0;
  
  for(let i = 0; i < s.length; i++) {
    if(checkCorrect(s)) answer++;
    s = s.substr(1) + s[0];
  }
  
  return answer;
}

const checkCorrect = ( str ) => {
  const front = [];
  
  for(let i = 0; i < str.length; i++) {
    if(str[i] == '(' || str[i] == '[' || str[i] == '{' ) {
      front.push(str[i]);
    }
    else if(str[i] == ')' && front[front.length - 1] == '(') {
      front.pop();
    }
    else if(str[i] == ']' && front[front.length - 1] == '[') {
      front.pop();
    }
    else if(str[i] == '}' && front[front.length - 1] == '{') {
      front.pop();
    }
    else {
      return false;
    }
  }
  
  if(front.length != 0) return false;
  
  return true;
}