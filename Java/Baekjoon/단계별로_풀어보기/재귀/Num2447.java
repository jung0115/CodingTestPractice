//백준 > 단계별로 풀어보기 > 재귀 > 별 찍기 - 10(2447)
package Java.Beakjoon.단계별로_풀어보기.재귀;

import java.util.Scanner;
public class Num2447 {
    static String[][] starCheck;
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        starCheck = new String[N][N];

        starSquare(N, 0, 0, true);

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                printSet.append(starCheck[i][j]);
            printSet.append("\n");
        }
        System.out.print(printSet);
    }
    static void starSquare(int N, int x, int y, boolean star){
        if(!star) {
            for(int i = x; i < x+N; i++) {
                for(int j = y; j < y+N; j++) {
                    starCheck[i][j] = " ";
                }
            }
            return;
        }
        if(N == 1) {
            starCheck[x][y] = "*";
            return;
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) starSquare(N/3, x + i*(N/3), y + j*(N/3), false);
                else starSquare(N/3, x + i*(N/3), y + j*(N/3), true);
            }
        }
    }
}
