// Samsung SW Expert Academy - 1210. Ladder1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
        
    // 테스트 케이스 10개
		for(int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(br.readLine());
            
      int[][] map = new int[100][100];
      int x = 0; // 도착점
      for(int i = 0; i < 100; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < 100; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          if(map[i][j] == 2) x = j;
        }
      }
            
      int y = 99;
      while(y > 0) {
        // 왼쪽 이동 가능
        if(x > 0 && map[y][x-1] == 1) {
        int left = x-1;
          while(left >= 0) {
            if(map[y-1][left] == 1) break;
            left--;
          }
          x = left;
        }
        
        // 오른쪽 이동 가능
        else if(x < 99 && map[y][x+1] == 1) {
          int right = x+1;
          while(right < 100) {
            if(map[y-1][right] == 1) break;
            right++;
          }
          x = right;
        }
        
        // 위로 이동
        y--;
      }
          
      printSet.append("#").append(num).append(" ").append(x).append("\n");
    }
      
    System.out.print(printSet);
	}
}