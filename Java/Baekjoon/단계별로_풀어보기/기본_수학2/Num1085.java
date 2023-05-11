//백준 > 단계별로 풀어보기 > 기본 수학2 > 직사각형에서 탈출(1085)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num1085 {
    public static void main(String[] args) {
        int x, y, w, h;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();
        scan.close();

        int[] len = new int[4];
        len[0] = x;
        len[1] = y;
        len[2] = w-x;
        len[3] = h-y;

        int min = len[0];
        for(int i = 1; i < 4; i++) {
            if(len[i] < min) min = len[i];
        }

        System.out.println(min);
    }
}
