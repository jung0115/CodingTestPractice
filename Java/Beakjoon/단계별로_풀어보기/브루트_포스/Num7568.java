//백준 > 단계별로 풀어보기 > 브루트 포스 > 덩치(7568)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.Scanner;
public class Num7568 {
    public static void main(String[] args) {
        int N;
        int[] x, y;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        x = new int[N];
        y = new int[N];
        for(int i = 0; i < N; i++){
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        scan.close();

        int[] lank = new int[N];
        for(int i = 0; i < N; i++) {
            lank[i] = 1;
            for(int j = 0; j < N; j++) {
                if(x[i] < x[j] && y[i] < y[j])
                    lank[i]++;
            }
        }

        for(int i = 0; i < N; i++)
            System.out.print(lank[i] + " ");
    }
}
