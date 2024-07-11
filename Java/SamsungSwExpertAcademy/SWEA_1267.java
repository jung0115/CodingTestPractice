// Samsung SW Expert Academy - 1267. 작업순서
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1267 {
  public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      int[][] edge = new int[E][2]; // 간선
      int[] edgeCnt = new int[V + 1];   // 각 정점마다 선행 정점의 개수
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < E; i++) {
        edge[i][0] = Integer.parseInt(st.nextToken());
        edge[i][1] = Integer.parseInt(st.nextToken());
        
        edgeCnt[edge[i][1]]++;
      }

      // 선행이 필요없는 정점
			Queue<Integer> queue = new LinkedList<>();
      for(int i = 1; i <= V; i++) {
        if(edgeCnt[i] == 0) {
          queue.offer(i);
        }
      }
      
      printSet.append("#").append(test_case);

      while(!queue.isEmpty()) {
        int currentValue = queue.poll();
        printSet.append(" ").append(currentValue);

        // 해당 정점이 선행되어야 하는 정점
        for(int i = 0; i < E; i++) {
          if(edge[i][0] == currentValue && edgeCnt[edge[i][1]] > 0) {
            edgeCnt[edge[i][1]]--;
            
            // 필요한 선행 정점이 사라졌다면
            if(edgeCnt[edge[i][1]] == 0) {
              queue.offer(edge[i][1]);
            }
          }
        }
      }

			printSet.append("\n");
		}

    System.out.print(printSet);
	}
}
