//백준 > 단계별로 풀어보기 > 브루트 포스 > 영화감독 숌(1436)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.Scanner;
public class Num1436 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        int num = 666, cnt = 1;
        while(N != cnt) {
            num++;
            if(checkEndNumber(num)) cnt++;
        }
        System.out.println(num);
    }
    static boolean checkEndNumber(int num) {
        int cnt = 0;
        while(num > 0){
            if(num%10 == 6) cnt++;
            else cnt = 0;
            num /= 10;
            if(cnt == 3) return true;
        }
        return false;
    }
}
