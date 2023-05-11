//정수 삼각형(1932)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num1932 {
    static int N;
    static int[][] inputTriangle;
    static Integer[][] triangleDp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        inputTriangle = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j <= i; j++) {
                inputTriangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        triangleDp = new Integer[N][N];
        for(int i = 0; i < N; i++) {
            triangleDp[N-1][i] = inputTriangle[N-1][i];
        }

        System.out.print(checkMax(0, 0));
    }
    static int checkMax(int startX, int startY) {
        if(triangleDp[startX][startY] == null) {
            triangleDp[startX][startY] = Math.max(checkMax(startX+1, startY), checkMax(startX+1, startY+1)) + inputTriangle[startX][startY];
        }

        return triangleDp[startX][startY];
    }
}
