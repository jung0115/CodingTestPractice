//백준 > 단계별로 풀어보기 > 기본 수학2 > 소인수분해(11653)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num11653 {
    public static void main(String[] args) {
        int N;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        for(int i = 2; i*i <= N; i++) {
            while((N%i) == 0) {
                N /= i;
                System.out.println(i);
            }
        }
        if(N != 1) System.out.println(N);
    }
}