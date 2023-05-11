// 백준 - 행렬 곱셈(2740)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num2740 {
    static int N, M, K, squareN, squareM, squareK;
    static int maxNM, maxMK;
    static int[][] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N * M 행렬 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        squareN = findMinSquareNum(N);
        squareM = findMinSquareNum(M);
        maxNM = (squareN >= squareM) ? squareN : squareM;

        A = new int[maxNM][maxNM];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // M * K 행렬 입력
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        squareK = findMinSquareNum(K);
        maxMK = (maxNM >= squareK) ? maxNM : squareK;

        B = new int[maxMK][maxMK];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideMatrix(0, 0, maxNM);
    }

    // num보다 크면서 가장 가까운 2의 제곱수 찾기
    static int findMinSquareNum(int num) {
        int min = 2;
        while(min < num) {
            min *= 2;
        }

        return min;
    }

    static int divideMatrix(int startX, int startY, int len) {
        if(len == 2) {
            
            return 1;
        }

        len /= 2;

        divideMatrix(startX, startY, len);
        divideMatrix(startX, startY + len, len);
        divideMatrix(startX + len, startY + len, len);
        divideMatrix(startX + len, startY, len);
        
        return 0;
    }
}
