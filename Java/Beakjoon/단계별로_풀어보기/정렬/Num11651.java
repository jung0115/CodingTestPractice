//백준 > 단계별로 풀어보기 > 정렬 > 좌표 정렬하기 2(11651)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
public class Num11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] dots = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        //람다식(익명함수) 이용
        Arrays.sort(dots, (dot1, dot2) -> {
            if(dot1[1] == dot2[1]) //y좌표 값이 같은 경우 x좌표로 비교
                return dot1[0] - dot2[0];
            else //다른 경우 y좌표로 비교
                return dot1[1] - dot2[1];
        });

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < N; i++)
            printSet.append(dots[i][0]).append(" ").append(dots[i][1]).append("\n");
        System.out.println(printSet);
    }
}
