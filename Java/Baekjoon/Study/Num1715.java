// 백준 - 카드 정렬하기(1715)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Num1715 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> cards = new PriorityQueue<>();
    for(int i = 0; i < N; i++) {
      cards.add(Integer.parseInt(br.readLine()));
    }

    int answer = 0;

    while(cards.size() > 1) {
      int sumCard = cards.poll() + cards.poll();
      cards.add(sumCard);

      answer += sumCard;
    }

    System.out.print(answer);
  }
}
