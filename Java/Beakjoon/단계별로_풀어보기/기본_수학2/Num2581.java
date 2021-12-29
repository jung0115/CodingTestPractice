//백준 > 단계별로 풀어보기 > 기본 수학2 > 소수(2581)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num2581 {
    public static void main(String[] args) {
        int M, N, sum = 0, min = -1;

        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        scan.close();

        for(int num = M; num <= N; num++) {
            if(primeNumber(num)) { //num이 소수인 경우
                sum += num;
                if(min == -1) min = num; //num은 계속 증가하므로 처음 등장한 소수가 가장 최솟값이 된다.
            }
        }

        if(min == -1){
            System.out.println(min);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
    static boolean primeNumber(int num){
        if(num == 1) return false; //1은 소수가 아니다.
        for(int i = 2; i <= num/2; i++) { //소수인지 아닌지 판별
            if(num%i == 0) return false; //소수가 아니면 false 반환
        }
        return true;
    }
}
