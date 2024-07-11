// Samsung SW Expert Academy - 1219. 길찾기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
        
		for(int test_case = 1; test_case <= 10; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int testNum = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      int[][] edge = new int[100][2];
      // -1로 초기화
      for(int i = 0; i < 100; i++) {
        edge[i][0] = -1;
        edge[i][1] = -1;
      }
      for(int i = 0; i < len; i++) {
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(edge[start][0] == -1) edge[start][0] = end;
        else edge[start][1] = end;
      }

      int answer = 0;
      Queue<Integer> queue = new LinkedList<Integer>();
      boolean[] visited = new boolean[100];
      queue.offer(0);
      while(!queue.isEmpty()) {
        int current = queue.poll();
          
        // 도착점
        if(current == 99) {
          answer = 1;
          break;
        }
        
        // 이어진 정점을 방문한 적이 없는 경우
        if(edge[current][0] != -1 && !visited[edge[current][0]]) {
          visited[edge[current][0]] = true;
          queue.offer(edge[current][0]);
        }
        if(edge[current][1] != -1 && !visited[edge[current][1]]) {
          visited[edge[current][1]] = true;
          queue.offer(edge[current][1]);
        }
      }
      
      printSet.append("#").append(testNum).append(" ").append(answer).append("\n");
		}
        
    System.out.print(printSet);
	}
}