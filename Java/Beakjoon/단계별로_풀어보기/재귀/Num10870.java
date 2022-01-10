//백준 > 단계별로 풀어보기 > 재귀 > 피보나치 수 5(10870)
package Java.Beakjoon.단계별로_풀어보기.재귀;

import java.util.Scanner;
public class Num10870 {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.close();
        
        int fibo_result;
        fibo_result = fibo(n);
        System.out.println(fibo_result);
    }
    static int fibo(int num) {
        if(num == 0 || num == 1) return num;
        return fibo(num-1) + fibo(num-2);
    }
}
