//백준 > 단계별로 풀어보기 > 동적 계획법1 > 피보나치 함수(1003)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num1003 {
    static Integer[][] fibo = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] test = new int[N];
        for(int i = 0; i < N; i++) {
            test[i] = Integer.parseInt(bf.readLine());
        }
        fibo[0][0] = 1; //0일 때 0 호출 횟수
        fibo[0][1] = 0; //0일 때 1 호출 횟수
        fibo[1][0] = 0; //1일 때 0 호출 횟수
        fibo[1][1] = 1; //1일 때 1 호출 횟수

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(fibo[test[i]][0] == null || fibo[test[i]][1] == null)
                fibonacci(test[i]);
            printSet.append(fibo[test[i]][0]).append(" ").append(fibo[test[i]][1]).append("\n");
        }
        System.out.print(printSet);
    }
    static void fibonacci(int num) {
        if(fibo[num][0] == null || fibo[num][1] == null) {
            fibonacci(num-1);
            fibonacci(num-2);
            fibo[num][0] = fibo[num-1][0] + fibo[num-2][0];
            fibo[num][1] = fibo[num-1][1] + fibo[num-2][1];
        }
    }
}
