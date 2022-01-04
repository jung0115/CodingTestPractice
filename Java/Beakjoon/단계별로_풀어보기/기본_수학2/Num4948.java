//백준 > 단계별로 풀어보기 > 기본 수학2 > 베르트랑 공준(4948)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num4948 {
    public static void main(String[] args) {
        int[] checkPrime = new int[246913];

        //1부터 123456*2, 즉 246912까지 각각 소수인지 아닌지 판단하여 배열에 저장
        for(int i = 1; i <= 246912; i++){
            checkPrime[i] = checkPrimeNumber(i);
        }

        Scanner scan = new Scanner(System.in);
        while(true) {
            int n, cnt = 0;
            n = scan.nextInt();
            if(n == 0) break;
            for(int i = n+1; i <= 2*n; i++) cnt += checkPrime[i]; //n보다 크고 2n보다 작거나 같은 소수의 개수 계산
            System.out.println(cnt);
        }
        scan.close();
    }
    static int checkPrimeNumber(int num) { //소수 판단 함수
        if(num == 1) return 0;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return 0; //소수가 아닌 경우
        }
        return 1; //소수인 경우
    }
}
