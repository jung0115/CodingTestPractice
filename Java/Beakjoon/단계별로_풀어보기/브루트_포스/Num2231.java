//백준 > 단계별로 풀어보기 > 브루트 포스 > 분해합(2231)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.Scanner;
public class Num2231 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        int sum, num, i;
        for(i = 1; i <= N; i++) {
            sum = i;
            num = i;
            while(num != 0) {
                sum += num%10;
                num /= 10;
            }
            if(sum == N) break;
        }
        if(i == (N+1)) System.out.println(0);
        else System.out.println(i);
    }
}
