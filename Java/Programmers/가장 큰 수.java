// 프로그래머스 - 가장 큰 수(Lv.2)
import java.util.Arrays;

class Solution {
  public String solution(int[] numbers) {
    String[] nums = new String[numbers.length];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = String.valueOf(numbers[i]);
    }

    // 내림차순 정렬
    Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
    
    // "000"처럼 0이 붙어있는 수가 나오지 않게
    if (nums[0].equals("0")) {
      return "0";
    }

    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < nums.length; i++) {
      answer.append(nums[i]);
    }
    
    return answer.toString();
  }
}