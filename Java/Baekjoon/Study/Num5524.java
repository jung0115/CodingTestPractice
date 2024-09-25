// 백준 - IOIOI(5525)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num5524 {
  final static String OI = "OI";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String S = br.readLine();

    // 패턴 IOI...OI 생성
    StringBuilder IOI = new StringBuilder();
    IOI.append("IOI");
    for (int i = 1; i < N; i++) {
      IOI.append(OI);
    }

    String pattern = IOI.toString();
    int patternLength = pattern.length();
    int answer = 0;

    // KMP 알고리즘을 사용하여 패턴 탐색
    int[] lps = computeLPSArray(pattern);

    int i = 0, j = 0;
    while (i < M) {
      if (S.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;

        if (j == patternLength) {
          answer++;
          j = lps[j - 1];
        }
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }

    System.out.print(answer);
  }

  // KMP 알고리즘에서 사용하는 LPS 배열 계산
  private static int[] computeLPSArray(String pattern) {
    int length = pattern.length();
    int[] lps = new int[length];
    int j = 0;  // 앞에서 일치하는 패턴의 길이
    for (int i = 1; i < length; ) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        j++;
        lps[i] = j;
        i++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
}