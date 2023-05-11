//백준 > 단계별로 풀어보기 > 재귀 > 하노이 탑 이동 순서(11729)
package Java.Beakjoon.단계별로_풀어보기.재귀;

import java.util.Scanner;
public class Num11729 {
    static StringBuilder move = new StringBuilder();
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.close();

        int cnt;
        cnt = hanoi(1, 2, 3, N);
        System.out.println(cnt);
        System.out.print(move);
    }
    static int hanoi(int start, int middle, int finish, int N) {
        if(N == 1) {
            move.append(start + " " + finish + "\n");
            return 1;
        }
        int cnt = 0;
        cnt += hanoi(start, finish, middle, N-1);
        move.append(start + " " + finish + "\n"); cnt++;
        cnt += hanoi(middle, start, finish, N-1);

        return cnt;
    }
}