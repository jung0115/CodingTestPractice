//백준 > 단계별로 풀어보기 > 백트래킹 > N과 M 4(15652)
package Java.Beakjoon.단계별로_풀어보기.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num15652 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[M];
        StringBuilder printSet = new StringBuilder();
        printSet = NandM(N, M, 0, num);
        System.out.println(printSet);
    }
    static StringBuilder NandM(int N, int M, int cnt, int[] num) {
        StringBuilder sequence = new StringBuilder();
        
        for(int i = 0; i < cnt-1; i++) //수열이 비내림차순이 아닌 경우
            if(num[cnt-1] < num[i]) return sequence;
        
        if(cnt == M) { //수열 완성
            for(int i = 0; i < M; i++)
                sequence.append(num[i]).append(" ");
            sequence.append("\n");
            return sequence;
        }

        for(int i = 1; i <= N; i++) {
            int[] next = new int[M];
            for(int j = 0; j < cnt; j++)
                next[j] = num[j];
            next[cnt] = i;
            sequence.append(NandM(N, M, cnt+1, next));
        }
        return sequence;
    }
}
