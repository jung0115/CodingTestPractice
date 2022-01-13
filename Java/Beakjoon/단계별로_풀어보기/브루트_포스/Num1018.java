//백준 > 단계별로 풀어보기 > 브루트 포스 > 체스판 다시 칠하기(1018)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.Scanner;
public class Num1018 {
    public static void main(String[] args) {
        int N, M;
        String[][] chess;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        chess = new String[N][M];
        String input = new String();
        for(int i = 0; i < N; i++) {
            input = scan.next(); //문자열 한 줄로 입력 받음
            chess[i] = input.split(""); //배열에 문자 한 글자씩 저장
        }
        scan.close();

        int min = N*M, check;
        for(int i = 0; i < N-7; i++) {
            for(int j = 0; j < M-7; j++) {
                check = checkMin(i, j, chess);
                if(min > check) min = check;
            }
        }
        
        System.out.println(min);
    }
    static int checkMin(int startI, int startJ, String[][] chess) {
        int startWhite = 0, startBlack = 0;
        String checkWhite;
        for(int i = startI; i < startI+8; i++) {
            if(i%2 == 0) checkWhite = "W";
            else checkWhite = "B";

            for(int j = startJ; j < startJ+8; j++) {
                if(checkWhite.equals(chess[i][j])) startBlack++;
                else startWhite++;

                if(checkWhite.equals("B")) checkWhite = "W";
                else checkWhite = "B";
            }
        }

        if(startWhite < startBlack) return startWhite;
        else return startBlack;
    }
}
