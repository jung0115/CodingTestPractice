// 프로그래머스 - 폰켓몬(Lv.2)
import java.util.HashSet;

class Solution {
  public int solution(int[] nums) {
    HashSet<Integer> ponkemon = new HashSet<>();
    
    for(int i = 0; i < nums.length; i++) {
      ponkemon.add(nums[i]); 
    }
    
    int answer = Math.min(nums.length / 2, ponkemon.size());
    
    return answer;
  }
}