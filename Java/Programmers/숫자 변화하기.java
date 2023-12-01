// 프로그래머스 - 숫자 변환하기(Lv.2)
class Solution {
  public int solution(int x, int y, int n) {
    int[] dp = new int[y + 1];
    
    for (int i = x; i < y + 1; i++) {
      // dp[i] == 0이면 연산해서 해당 숫자가 나올 수 없었다는 뜻
      if (i != x && dp[i] == 0) {
        dp[i] = -1;
        continue;
      }
      
      // 가능한 연산
      if (i * 2 <= y)
        dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
      
      if (i * 3 <= y)
        dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
      
      if (i + n <= y)
        dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
    }
    
    return dp[y];
  }
}