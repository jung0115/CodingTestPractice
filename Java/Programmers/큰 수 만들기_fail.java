// 프로그래머스 - 큰 수 만들기(Lv.2) | 83.3 / 100.0
class Solution {
  public String solution(String number, int k) {
    String answer = number;
    
    for(int i = 1; i < answer.length(); i++) {
      if(answer.charAt(i-1) < answer.charAt(i)) {
        answer = answer.substring(0, i-1) + answer.substring(i, answer.length());
        i = 0;
      }
      
      if(answer.length() == number.length() - k)
        break;
    }
    
    
    return answer;
  }
}