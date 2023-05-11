//백준 > 단계별로 풀어보기 > 기본 수학2 > 소수 찾기(1978)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num1978 {
    public static void main(String[] args) {
        int N; //입력 받을 수의 개수
        int[] input_num = new int[100];
        int cnt = 0; //소수의 개수

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        for(int i = 0; i < N; i++) {
            input_num[i] = scan.nextInt();
        }

        scan.close();

        for(int i = 0; i < N; i++) {
            cnt += primeNumber(input_num[i]);
        }

        System.out.print(cnt);
    }
    static int primeNumber(int num){
        if(num == 1) return 0; //1은 소수가 아니다.
        for(int i = 2; i <= num/2; i++) { //소수인지 아닌지 판별
            if(num%i == 0) return 0; //소수가 아니면 0 반환
        }
        return 1;
    }
}
