//백준 > 단계별로 풀어보기 > 재귀 > 팩토리얼(10872)
package Java.Beakjoon.단계별로_풀어보기.재귀;

import java.util.Scanner;
public class Num10872 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        int fac;
        fac = factorial(N);

        System.out.println(fac);
    }
    static int factorial(int n) {
        if(n == 0 || n == 1) return 1;
        return factorial(n-1) * n;
    }
}