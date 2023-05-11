//백준 > 단계별로 풀어보기 > 동적 계획법1 > 신나는 함수 실행(9184)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num9184 {
    static int[][][] wSet = new int[21][21][21]; //배열 크기가 중요!
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a, b, c, result;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break; //종료조건
            result = w(a, b, c);
            StringBuilder printSet = new StringBuilder();
            printSet.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
            System.out.print(printSet);
        }
    }
    static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            wSet[0][0][0] = 1;
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {//바로 위 if문과 이 부분 때문에 wSet 배열의 크기가 저렇게 정해짐
            wSet[20][20][20] = w(20, 20, 20);
            return wSet[20][20][20];
        }

        if(wSet[a][b][c] != 0) //이미 계산되어 있는 경우
            return wSet[a][b][c];
        
        if(a < b && b < c) {
            wSet[a][b][c] = (w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c));
            return wSet[a][b][c];
        }
        
        wSet[a][b][c] = (w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1));
        return wSet[a][b][c];
    }
}