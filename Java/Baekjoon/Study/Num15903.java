// 백준 - 카드 합체 놀이(15903)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num15903 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] cardStatus = new long[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      cardStatus[i] = Long.parseLong(st.nextToken());
    }

    PriorityQueue<Long> pq = new PriorityQueue<>();

    for(int i = 0; i < n; i++) {
      pq.add(cardStatus[i]);
    }

  for(int i = 0; i < m; i++) {
    long a = pq.poll();
    long b = pq.poll();

    pq.add(a + b);
    pq.add(a + b);
    }

    long answer = 0;
    
    
    while(!pq.isEmpty()) {
      answer += pq.poll();
    }

    System.out.println(answer);
  }
}
