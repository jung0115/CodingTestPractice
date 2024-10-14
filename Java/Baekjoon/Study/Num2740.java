// 백준 - 행렬 곱셈(2740)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num2740 {
    static int N, M, K;
    static int[][] A, B, C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        // N * M 행렬 A 입력
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // M * K 행렬 B 입력
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); // 다시 입력하는 M (확인용)
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // N * K 행렬 C (결과 행렬) 생성 및 곱셈 수행
        C = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int l = 0; l < M; l++) {
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }
        
        // 결과 행렬 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                sb.append(C[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}