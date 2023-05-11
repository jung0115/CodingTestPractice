//1로 만들기(1463)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num1463 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 0;

        if(N >= 2) dp[2] = 1;
        if(N >= 3) dp[3] = 1;

        System.out.print(makeOne(N));
    }
    static long makeOne(int N) {
        if(N > 1 && dp[N] == 0) {
            if(N%6 == 0) {
                long m = Math.min(makeOne(N / 3), makeOne(N / 2));
                dp[N] = Math.min(m, makeOne(N - 1)) + 1;
            }
            else if(N%3 ==0) dp[N] = Math.min(makeOne(N / 3), makeOne(N - 1)) + 1;
            else if(N%2 ==0) dp[N] = Math.min(makeOne(N / 2), makeOne(N - 1)) + 1;
            else dp[N] = makeOne(N - 1) + 1;
        }
        
        return dp[N];
    }
}
