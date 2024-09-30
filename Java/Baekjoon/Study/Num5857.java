// 백준 - 오타(5875)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num5857 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
 
    // 처음 또는 끝을 고쳐야 하는 경우
    if(str.charAt(0) == ')' || str.charAt(str.length() - 1) == '(') {
      System.out.print(1);
      return;
    }
      
    int[] sums = new int[str.length()];
    for(int i = 0; i < str.length(); i++) {
      int past = 0;
      if(i > 0) past = sums[i - 1];

      if(str.charAt(i) == '(') sums[i] = past + 1;
      else sums[i] = past - 1;
    }

    int answer = 0;
    // 마지막이 0 또는 더 작은 수 -> 감소하는 부분
    // 음수에서 음수로 감소하는 경우는 제외
    if(sums[str.length() - 1] <= 0) {
      for(int i = 1; i < str.length(); i++) {
        if(sums[i - 1] < 0) break;

        if(sums[i] < sums[i - 1])
          answer++;
      }
    }

    // 마지막이 0이 아님 -> 증가하는 부분
    // 0에서 1로 증가하는 경우는 제외
    else {
      for(int i = str.length() - 1; i > 0; i--) {
        if(sums[i - 1] == 0) break;

        if(sums[i] > sums[i - 1])
          answer++;
      }
    }

    System.out.print(answer);
  }
} 