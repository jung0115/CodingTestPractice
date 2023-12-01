// 프로그래머스 - 숫자 변환하기(Lv.2) -> 56.3 / 100.0
class Solution {
  public int solution(int x, int y, int n) {
    int answer = 0;
    
    while(y > x) {
      int num1 = 0;
      if(y % 3 == 0)
        num1 = y / 3;
      else if(y % 2 == 0)
        num1 = y / 2;
      
      int num2 = y - n;
      
      y = num1 == 0 ? num2 : Math.min(num1, num2);
      answer++;
    }
    
    if(y != x) {
      answer = -1;
    }
    
    return answer;
  }
}