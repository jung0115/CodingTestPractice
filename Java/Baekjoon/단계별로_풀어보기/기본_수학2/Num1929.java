//백준 > 단계별로 풀어보기 > 기본 수학2 > 소수 구하기(1929)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num1929 {
    public static void main(String[] args) {
        int M, N;

        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        scan.close();

        for(int i = M; i <= N; i++){
            if(checkPrimeNumber(i)){ //i가 소수인 경우
                System.out.println(i); //출력
            }
        }
    }
    static boolean checkPrimeNumber(int num) { //소수 판단 함수
        if(num == 1) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false; //소수가 아닌 경우
        }
        return true; //소수인 경우
    }
}
