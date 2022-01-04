//백준 > 단계별로 풀어보기 > 기본 수학2 > 골드바흐의 추측(9020)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num9020 {
    static boolean[] checkPrime = new boolean[10001];
    public static void main(String[] args) {
        //1부터 10000까지의 수가 각각 소수인지 판단하여 배열에 저장
        for(int i = 1; i <= 10000; i++) {
            checkPrime[i] = checkPrimeNumber(i);
        }

        int T;
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scan.nextInt();
            Goldbach(n);
        }
        scan.close();
    }
    static boolean checkPrimeNumber(int num) { //소수 판단 함수
        if(num == 1) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false; //소수가 아닌 경우
        }
        return true; //소수인 경우
    }
    static void Goldbach(int num) { //num에 대한 골드바흐 파티션을 찾아서 출력하는 함수
        int max, min, sum;
        max = maxPrime(num/2);
        min = minPrime(num/2);
        while(true) {
            sum = max + min;
            if(sum == num) break; //num에 대한 골드바흐 파티션을 찾은 경우
            else if(sum > num) min = minPrime(min-1);
            else max = maxPrime(max+1);
        }
        System.out.println(min + " " + max);
    }
    static int maxPrime(int num) { //num보다 큰 수 중 가장 작은 소수
        for(int i = num; ; i++)
            if(checkPrime[i]) return i;
    }
    static int minPrime(int num) { //num보다 작은 수 중 가장 작은 소수
        for(int i = num; ; i--)
            if(checkPrime[i]) return i;
    }
}
