// 백준 - 여왕벌(10836)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num10836 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] size = new int[M * 2 - 1];

    while(N-- > 0) {
      st = new StringTokenizer(bf.readLine());

      int idx = Integer.parseInt(st.nextToken());

      for(int i = 1; i <= 2; i++) {
        int grow = Integer.parseInt(st.nextToken());

        while (grow-- > 0) {
          size[idx] += i;
          idx++;
        }
      }
    }

    StringBuilder answer = new StringBuilder();
    for(int i = M-1; i >= 0; i--) {
      answer.append(size[i] + 1).append(" ");
      for(int j = M; j <= M*2-2; j++) {
        answer.append(size[j] + 1).append(" ");
      }
      answer.append("\n");
    }

    System.out.print(answer);
  }
}
