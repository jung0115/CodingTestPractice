// 프로그래머스 - 올바른 괄호(Lv.2)
import java.util.Stack;

class Solution {
  boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == ')') {
        // () 쌍 확인
        if(!stack.empty() && stack.peek() == '(') {
          stack.pop();
          continue;
        }
      }
      stack.push(s.charAt(i));
    }
      
    return stack.empty();
  }
}