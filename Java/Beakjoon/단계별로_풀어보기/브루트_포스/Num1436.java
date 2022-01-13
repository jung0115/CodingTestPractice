//백준 > 단계별로 풀어보기 > 브루트 포스 > 영화감독 숌(1436)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.ArrayList;
import java.util.Scanner;
public class Num1436 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        int cnt = 1, endNum = 666;
        while(cnt != N) {
            endNum = endNumber(endNum);
            cnt++;
        }
        System.out.println(endNum);
    }
    static int endNumber(int num){
        ArrayList<Integer> numArray = new ArrayList<>();
        int check = num;
        while(check > 0) {
            numArray.add(check%10);
            check /= 10;
        }
        
        if()
        //나중에 이어서 풀기
    }
}
