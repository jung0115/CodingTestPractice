//백준 > 단계별로 풀어보기 > 백트래킹 > 스타트와 링크(14889)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;
public class Num14889 {
    static int[][] skillScore;
    static int min = 1000000; //능력치 차이 최소값
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        skillScore = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++) {
                skillScore[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] start = new int[N/2];
        startAndLink(N, start, 0);
        System.out.print(min);
    }
    static void startAndLink(int N, int[] start, int cnt) {
        if(cnt == N/2) {
            int scoreSub = calculateScore(N, start);
            if(scoreSub < min){
                min = scoreSub;
            }
            return;
        }

        int startI =0;
        if(cnt != 0) startI = start[cnt-1]+1;
        for(int i = startI; i < N; i++) {
            start[cnt] = i;
            startAndLink(N, start, cnt+1);
        }
    }
    static int calculateScore(int N, int[] start) {
        int[] link = new int[N/2];
        int cntS = 0, cntL = 0;
        for(int i = 0; i < N; i++) {
            if(cntS == N/2 || start[cntS] != i) {
                link[cntL] = i;
                cntL++;
                if(cntL == N/2) break;
            }
            else cntS++;
        }

        //스타트 팀의 능력치 계산
        int startScore = 0;
        for(int i = 0; i < N/2; i++) {
            for(int j = i+1; j < N/2; j++) {
                startScore += skillScore[start[i]][start[j]];
                startScore += skillScore[start[j]][start[i]];
            }
        }

        //링크 팀의 능력치 계산
        int linkScore = 0;
        for(int i = 0; i < N/2; i++) {
            for(int j = i+1; j < N/2; j++) {
                linkScore += skillScore[link[i]][link[j]];
                linkScore += skillScore[link[j]][link[i]];
            }
        }
        
        return Math.abs(startScore - linkScore); //스타트 팀과 링크 팀의 능력치 차 반환
    }
}
