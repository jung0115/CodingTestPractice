// 프로그래머스 - 큰 수 만들기(Lv.2)
class Solution {
  public String solution(String number, int k) {
    StringBuilder answer = new StringBuilder("");
    int len = number.length() - k;
    int start = 0;
    
    while(start < number.length() && answer.length() != len) {
      int leftNum = k + answer.length();
      int max = 0;
      for (int i = start; i <= leftNum; i++) {
        if (max < number.charAt(i) - '0') {
          max = number.charAt(i) - '0';
          start = i + 1;
        }
      }
      answer.append(Integer.toString(max));
    }
    return answer.toString();
  }
}