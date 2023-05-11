//계단 오르기(2579)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;
public class Num2579 {
    static Integer[] maxDp;
    static int score[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        score = new int[N+1];
        for(int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(bf.readLine());
        }
        maxDp = new Integer[N+1];
        maxDp[0] = 0;
        maxDp[1] = score[1];

        if(N >= 2) {
            maxDp[2] = score[1] + score[2];
        }

        int result = maxScore(N);

        System.out.print(result);
    }
    static int maxScore(int N) {
        if(maxDp[N] == null) {
            maxDp[N] = Math.max(maxScore(N - 2), maxScore(N - 3) + score[N - 1]) + score[N];
        }
        return maxDp[N];
    }
}
