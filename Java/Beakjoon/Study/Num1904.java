//01타일(1904)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num1904 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        bf.close();

        dp = new int[N+2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.print(tile(N));
    }
    static int tile(int N) {
        if(dp[N] == 0) {
            dp[N] = (tile(N-1) + tile(N-2)) % 15746;
        }
        return dp[N];
    }
}