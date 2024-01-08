// 프로그래머스 - 이진 변환 반복하기(Lv.2)
import java.util.ArrayList;

class Solution {
  public int[] solution(String s) {
    int[] answer = new int[2];
    
    while(!s.equals("1")) {
      String s2 = s.replace("0", "");
      
      int zero = s.length() - s2.length();
      answer[1] += zero;
      
      System.out.println(s2);
      
      s = Integer.toBinaryString(s2.length());
      answer[0]++;
    }
    
    return answer;
  }
}