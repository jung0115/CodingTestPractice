// RGB거리(1149)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num1149 {
    static int[][] house;
    static Long[] redDp;
    static Long[] greenDp;
    static Long[] blueDp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        house = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bf.close();

        redDp = new Long[N];
        greenDp = new Long[N];
        blueDp = new Long[N];

        redDp[0] = Long.valueOf(house[0][0]);
        greenDp[0] = Long.valueOf(house[0][1]);
        blueDp[0] = Long.valueOf(house[0][2]);

        paint(N-1);

        Long result = Math.min(redDp[N-1], Math.min(greenDp[N-1], blueDp[N-1]));
        System.out.print(result);
    }
    static void paint(int N) {
        if(redDp[N-1] == null) {
            paint(N-1);
        }
        redDp[N] = Math.min(blueDp[N-1], greenDp[N-1])+ house[N][0];
        greenDp[N] = Math.min(redDp[N-1], blueDp[N-1])+ house[N][1];
        blueDp[N] = Math.min(redDp[N-1], greenDp[N-1])+ house[N][2];
    }
}
