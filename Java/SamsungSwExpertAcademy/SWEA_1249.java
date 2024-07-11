// Samsung SW Expert Academy - 1249. 보급로
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;

class Solution {
  static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
  static class Road {
    int x;
    int y;
    int time;
    
    Road(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }
    
	public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++){
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];
      for(int i = 0; i < N; i++) {
        String[] input = br.readLine().split("");
        for(int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(input[j]);   
        }
      }
      
      int answer = bfs(N, map);
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        
    System.out.print(printSet);
	}
    
  static int bfs(int N, int[][] map) {
    int[][] minTime = new int[N][N];
    // 일단 복구시간 최대로 초기화
    for(int i = 0; i < N; i++) {
      Arrays.fill(minTime[i], Integer.MAX_VALUE);
    }
    
    Queue<Road> queue = new LinkedList<Road>();
    minTime[0][0] = 0; // 시작점은 복구 시간 0
    queue.offer(new Road(0, 0, 0));
    
    int resultTime = Integer.MAX_VALUE;
    while(!queue.isEmpty()) {
      Road current = queue.poll();
      // 도착지에 도착했을 경우
      if(current.x == N - 1 && current.y == N -1) {
        resultTime = Math.min(resultTime, current.time);
        // 도착지에 도달하는 경우의 수가 하나가 아닐 수 있기 때문에 break가 아니라
        // conitue로 복구 시간 계산 부분만 건너뛰기
        continue;
      }
      
      // 상하좌우 이동
      for(int i = 0; i < 4; i++) {
        int moveX = current.x + dx[i];
        int moveY = current.y + dy[i];
        
        // 범위 벗어나는지 확인
        if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) continue;
        
        // 해당 도로를 지나갈 경우 총 복구 시간
        int time = current.time + map[moveX][moveY];
        
        // 이전에 이 도로를 지나갔던 경로보다 더 짧은 시간에 복구가 가능하다면
        // minTime 갱신
        if(minTime[moveX][moveY] > time) {
          minTime[moveX][moveY] = time;
          queue.offer(new Road(moveX, moveY, time));
        }
      }
    }
    
    return resultTime;
  }
}