// 백준 - 파일 합치기(11066)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(bf.readLine());
            int[] fileSizes = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 1; j <= K; j++) {
                fileSizes[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1] + fileSizes[j];
            }

            for(int n = 1; n <= K; n++) { // 몇 개의 chapter를 묶을지
                for(int from = 1; from + n <= K; from++) { // 몇 번 chapter부터 묶을지
                    int to = from + n; // 몇 번 chapter까지 (시작 chapter + 범위)
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                        // from ~ divide까지의 chapter를 모두 합하는 최소비용: dp[from][divide]
                        // divide+1 ~ to까지의 chapter를 모두 합하는 최소비용: dp[divide + 1][to]
                        // dp[from][divide]와 dp[divide + 1][to] 파일을 합하는데 드는 비용: sum[to] - sum[from - 1]
                    }
                }
            }

            System.out.println(dp[1][K]); // chapter 1부터 K까지
        }

    }
}
