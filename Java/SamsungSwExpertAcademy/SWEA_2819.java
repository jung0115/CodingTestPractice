// Samsung SW Expert Academy - 2819. 격자판의 숫자 이어 붙이기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.io.FileInputStream;

class Solution
{
  static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
  static Set<String> set = new HashSet<String>();
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
      // 입력 부분
			String[][] input = new String[4][4];
      for(int i = 0; i < 4; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < 4; j++) {
          input[i][j] = st.nextToken();
        }
      }
            
      set = new HashSet<String>();
			for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
          StringBuilder str = new StringBuilder();
          str.append(input[i][j]);
          dfs(str, input, i, j);
        }
      }
            
            
      int answer = set.size();
      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
    System.out.print(printSet);
	}
    
  static void dfs(StringBuilder str, String[][] input, int x, int y) {
    if(str.length() == 7) {
      set.add(str.toString());
      return;
    }
    
    for(int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];
      
      if(moveX < 0 || moveX >= 4 || moveY < 0 || moveY >= 4) continue;
      
      str.append(input[moveX][moveY]);
      dfs(str, input, moveX, moveY);
      str.deleteCharAt(str.length() - 1);
    }
  }
}