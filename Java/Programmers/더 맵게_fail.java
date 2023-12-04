// 프로그래머스 - 더 맵게(Lv.2) - 32.3 / 100.0
import java.util.Arrays;

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    
    Arrays.sort(scoville);
    
  while(scoville[answer] < K) {
      // 가장 맵지 않은 음식의 스코빌 지수
      int sco = scoville[answer];
      // 두 번째로 맵지 않은 음식의 스코빌 지수 * 2
      sco += scoville[answer + 1] * 2;
      
      scoville[answer] = 0;
      scoville[answer + 1] = sco;
      answer++;
    }
    
    return answer;
  }
}