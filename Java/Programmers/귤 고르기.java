// 프로그래머스 - 귤 고르기(Lv.2)
import java.util.Arrays;

class Solution {
  public int solution(int k, int[] tangerine) {
    int answer = 0;
    int[] count = new int[10000001];
    
    for(int i = 0; i < tangerine.length; i++) {
      count[tangerine[i]]++;
    }
    
    Arrays.sort(count);
    
    for(int i = 10000000; i >= 1 && k > 0; i--) {
      k -= count[i];
      answer++;
    }
    
    return answer;
  }
}