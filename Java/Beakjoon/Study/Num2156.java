//포도주 시식
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num2156 {
    static int[] grape;
    static Long[] grapeDp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        grape = new int[N+1];

        int max = 0;
        for(int i = 1; i < N+1; i++) {
            grape[i] = Integer.parseInt(bf.readLine());
            if(max < grape[i]) max = grape[i];
        }

        grapeDp = new Long[N+1];
        grapeDp[0] = 0L;
        grapeDp[1] = Long.valueOf(grape[1]);
        if(N >= 2) grapeDp[2] = Long.valueOf(grape[1] + grape[2]);
        
        System.out.print(drinkGrape(N));
    }
    static Long drinkGrape(int N) {
        if(grapeDp[N] == null) {
            grapeDp[N] = Math.max(Math.max(drinkGrape(N-3) + grape[N-1], drinkGrape(N-2)) + grape[N], drinkGrape(N-1));
        }
        return grapeDp[N];
    }
}
