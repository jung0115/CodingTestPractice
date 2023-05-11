//파도반 수열(9461)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num9461 {
    static Long[] dp = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            System.out.println(P(N));
        }
        bf.close();
    }
    static Long P(int N) {
        if(dp[N] == null) {
            dp[N] = P(N-3) + P(N-2);
        }
        return dp[N];
    }
}
