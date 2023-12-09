// 프로그래머스 - 피로도(Lv.2)
class Solution {
  static boolean[] visited;
  static int max = 0;
  public int solution(int k, int[][] dungeons) {
      
    visited = new boolean[dungeons.length];
    checkDungeon(dungeons, k, 0);
    
    return max;
  }
  static void checkDungeon(int[][] dungeons, int k, int cnt) {
    if(max < cnt) max = cnt;
    
    for(int i = 0; i < dungeons.length; i++) {
      if(!visited[i] && dungeons[i][0] <= k) {
        visited[i] = true;
        checkDungeon(dungeons, k - dungeons[i][1], cnt + 1);
        visited[i] = false;
      }
    }
  }
}