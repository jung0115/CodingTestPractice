// 백준 - 꼬마 정민(11382)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num11382 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    Long num1 = Long.parseLong(st.nextToken());
    Long num2 = Long.parseLong(st.nextToken());
    Long num3 = Long.parseLong(st.nextToken());

    Long sum = num1 + num2 + num3;
    System.out.print(sum);
  }
}
