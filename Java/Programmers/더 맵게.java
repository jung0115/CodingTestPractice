// 프로그래머스 - 더 맵게(Lv.2)
import java.util.PriorityQueue;

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    for (int i = 0; i < scoville.length; i++) {
      queue.add(scoville[i]);
    }
    
    while(queue.peek() < K) {
      // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
      if (queue.size() == 1)
        return -1;
      
      // 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
      queue.add(queue.poll() + queue.poll() * 2);
      answer++;
    }
    
    return answer;
  }
}