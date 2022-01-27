//백준 > 단계별로 풀어보기 > 백트래킹 > 스도쿠(2580)
package Java.Beakjoon.단계별로_풀어보기.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num2580 {
    static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 9; j++)
                sudoku[i][j] = Integer.parseInt(st.nextToken());
        }

        findAnswer(0, 0);
    }
    static void findAnswer(int x, int y) {
        if(y == 9) { //해당 행이 다 채워졌을 경우 다음 행으로
            findAnswer(x+1, 0);
            return;
        }
        if(x == 9) { //모든 칸이 다 채워졌을 경우 출력 후 종료
            printSudoku();
            System.exit(0); //시스템 종료
        }

        if(sudoku[x][y] == 0) { //해당 칸이 비어있는 경우
            for(int i = 1; i <= 9; i++) {
                if(checkCorrect(x, y, i)) {
                    sudoku[x][y] = i;
                    findAnswer(x, y+1);
                }
            }
            sudoku[x][y] = 0; //정답이 아니었던 경우
            return;
        }

        findAnswer(x, y+1);
    }
    static boolean checkCorrect(int x, int y, int value) { //value 값이 (x,y)에 들어가도 되는지 검사
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == value) return false; //같은 행에 이미 해당 숫자가 있는 경우
            if(sudoku[i][y] == value) return false; //같은 열에 이미 해당 숫자가 있는 경우
        }
        int checkX = (x/3)*3;
        int checkY = (y/3)*3;
        for(int i = checkX; i < checkX+3; i++) {
            for(int j = checkY; j < checkY+3; j++)
                if(sudoku[i][j] == value) return false; //같은 3*3 사각형 칸에 해당 숫자가 있는 경우
        }
        return true;
    }
    static void printSudoku() { //출력
        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) 
                printSet.append(sudoku[i][j]).append(" ");
            printSet.append("\n");
        }
        System.out.print(printSet);
    }
}