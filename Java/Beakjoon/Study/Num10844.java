//쉬운 계단 수(10844)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num10844 {
    static Long[][] dp;
    final static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        bf.close();

        dp = new Long[N+1][10];

        dp[1][0] = 0L;
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1L;
        }

        Long sum = 0L;
        for(int i = 0; i < 10; i++) {
            sum += stairNum(N, i) % MOD;
        }

        System.out.print(sum % MOD);
    }
    static Long stairNum(int N, int last) {
        if(dp[N][last] == null) {
            if(last == 0) {
                dp[N][last] = stairNum(N - 1, 1);
            }
            else if(last == 9) {
                dp[N][last] = stairNum(N - 1, 8);
            }
            else {
                dp[N][last] = stairNum(N - 1, last - 1) + stairNum(N - 1, last + 1);
            }
        }

        return dp[N][last] % MOD;
    }
}
