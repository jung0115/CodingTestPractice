//백준 > 단계별로 풀어보기 > 백트래킹 > N-Queen(9663)
package Java.Beakjoon.단계별로_풀어보기.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num9663 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int[][] chess = new int[N][2];
        int result = Nqueen(N, chess, 0);
        System.out.println(result);
    }
    static int Nqueen(int N, int[][] chess, int cnt) {
        for(int i = 0; i < cnt-1; i++) {
            if(chess[cnt-1][0] == chess[i][0]) return 0; //위아래(수직)으로 공격할 수 있는 경우
            if(Math.abs(chess[cnt-1][0]-chess[i][0]) == Math.abs(chess[cnt-1][1]-chess[i][1])) return 0; //대각선으로 이동해 공격할 수 있는 경우
        }
        
        if(cnt == N) { //퀸 N개를 서로 공격하지 못하도록 놓은 경우(성공)
            return 1;
        }

        //한 행에 퀸이 하나씩 위치할 수 있다는 점을 이용
        int correct = 0;
        for(int i = 0; i < N ; i++) {
            chess[cnt][0] = i;
            chess[cnt][1] = cnt;
            correct += Nqueen(N, chess, cnt+1);
        }
        
        return correct;
    }
}
