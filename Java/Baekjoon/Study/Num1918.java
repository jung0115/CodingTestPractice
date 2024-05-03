// 백준 - 후위 표기식(1918)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num1918 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 중위 표기식
    String str = br.readLine();

    // 후위 표기식 작성할 변수
    StringBuilder answer = new StringBuilder();

    // 연산자
    Stack<Character> operator = new Stack<>();

    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      // 알파벳 -> 뒤에 붙이기
      if(c >= 'A' && c <= 'Z') {
        answer.append(c);
      }

      // 괄호 ( -> 연산자 스택에 넣어두기
      else if(c == '(') {
        operator.add(c);
      }

      // 괄호 ) -> 연산자 스택에서 ( 나오기 전까지 pop -> 나온 연산자들은 answer 뒤에 붙이기
      else if(c == ')') {
        while(operator.peek() != '(') {
          answer.append(operator.pop());
        }
        // ( 까지 제거
        operator.pop();
      }

      // 연산자 +, -, *, /
      else {
        // stack pop 했을 때 현재 체크 중인 연산자보다 우선순위 높거나 같은 연산자를 answer 뒤에 붙여주기
        while(!operator.isEmpty() && priority(operator.peek()) >= priority(c)) {
          answer.append(operator.pop());
        }

        // 현재 체크 중인 연산자는 stack에 넣어두기
        // 뒤에 우선순위 높은 연산자나 괄호가 나타날 수도 있기 때문에
        operator.add(c);
      }
    }

    // 남은 연산자들은 answer 뒤에 다 붙이기
    while(!operator.isEmpty()) {
      answer.append(operator.pop());
    }

    System.out.print(answer.toString());
  }

  // 우선순위 체크
  static int priority(char c) {
    if(c == '(' || c == ')') return 0;
    else if(c == '+' || c == '-') return 1;
    else if(c == '*' || c == '/') return 2;
    
    return -1;
  }
}