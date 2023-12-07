// 프로그래머스 - H-Index(Lv.2)
import java.util.Arrays;

class Solution {
  public int solution(int[] citations) {
    // 오름차순 정렬
    Arrays.sort(citations);
    
    // h가 0인 경우를 대비해서 h 계산하는 변수와 정답 변수를 따로 둠
    int answer = 0;
    
    for(int i = 0; i < citations.length; i++) {
      // 논문 수
      int h = citations.length - i;
      
      // 인용 횟수가 논문 수보다 크다면
      // h번 이상 인용된 논문이 h편 이상이라는 조건에 부합
      if(citations[i] >= h) {
        answer = h;
        break;
      }
    }
    
    return answer;
  }
}