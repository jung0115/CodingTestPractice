//백준 > 단계별로 풀어보기 > 기본 수학2 > 직각삼각형(4153)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num4153 {
    public static void main(String[] args) {
        int[] len = new int[3];
        Scanner scan = new Scanner(System.in);
        while(true) {
            len[0] = scan.nextInt();
            len[1] = scan.nextInt();
            len[2] = scan.nextInt();
            if(len[0] == 0) break;
            boolean check;
            check = checkTriangle(len);
            if(check) System.out.println("right");
            else System.out.println("wrong");
        }
        scan.close();
    }
    static boolean checkTriangle(int[] len) {
        //최대값 팀색
        int max = 0;
        if(len[max] < len[1]) max = 1;
        if(len[max] < len[2]) max = 2;
        
        int square1, square2;
        square1 = len[max]*len[max];
        len[max] = 0;
        square2 = len[0]*len[0] + len[1]*len[1] + len[2]*len[2];

        if(square1 == square2) return true;
        return false;
    }
}