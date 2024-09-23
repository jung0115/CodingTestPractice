// 백준 - 이중 우선순위 큐(7662)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Num7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int test = 0; test < T; test++) {
      int K = Integer.parseInt(br.readLine());

      TreeMap<Integer, Integer> map = new TreeMap<>();
      for(int i = 0; i < K; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String oper = st.nextToken();

        int num = Integer.parseInt(st.nextToken());

        if(oper.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
        }
        else if(oper.equals("D")) {
          if(map.size() == 0) continue;

          int removeNum;
					if(num == 1) { //최댓값 삭제 
						removeNum = map.lastKey();
					}
          else { // 최솟값 삭제
						removeNum = map.firstKey();
					}
					if(map.put(removeNum, map.get(removeNum) - 1) == 1) {
						map.remove(removeNum);
					}
        }
      }

      if (map.size()==0) {
        printSet.append("EMPTY\n");
      } else {
        printSet.append(map.lastKey() + " " + map.firstKey() + "\n");
      }
    }
    
    System.out.print(printSet);
  }
}
