//백준 > 단계별로 풀어보기 > 기본 수학2 > 네 번째 점(3009)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num3009 {
    public static void main(String[] args) {
        int[][] square = new int[3][2];
        
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            square[i][0] = scan.nextInt();
            square[i][1] = scan.nextInt();
        }
        scan.close();

        int x, y;
        x = different(square[0][0], square[1][0], square[2][0]);
        y = different(square[0][1], square[1][1], square[2][1]);

        System.out.println(x + " " + y);
    }
    static int different(int a, int b, int c) { //a, b, c 중 혼자 다른 수를 반환
        if(a == b) return c;
        if(a == c) return b;
        return a;
    }
}
