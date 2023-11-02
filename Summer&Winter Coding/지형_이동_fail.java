// 프로그래머스 - 지형 이동(Lv.4) - 실패
// 사다리 설치 비용을 고려하지 않음
class Solution {
  static int[][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  public int solution(int[][] land, int height) {
    int answer = 0;
    int N = land.length;
    visited = new int[N][N];
    
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(visited[i][j] == 0) {
          answer++;
          move(answer, N, height, land, i, j);
        }
      }
    }
    
    return answer - 1;
  }

  static void move(int num, int N, int height, int[][] land, int x, int y) {
    for(int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];
      if(moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
        int sub = Math.abs(land[x][y] - land[moveX][moveY]);
        if(visited[moveX][moveY] == 0 && sub <= height) {
          visited[moveX][moveY] = num;
          move(num, N, height, land, moveX, moveY);
        }
      }
    }
  }
}