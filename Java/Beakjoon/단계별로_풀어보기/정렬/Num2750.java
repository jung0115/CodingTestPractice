//백준 > 단계별로 풀어보기 > 정렬 > 수 정렬하기(2750)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.util.Scanner;
public class Num2750 {
    public static void main(String[] args) {
        int N;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int[] num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = scan.nextInt();
        }
        scan.close();

        for(int i = 0; i < N-1; i++) {
            int min = i;
            for(int j = i+1; j < N; j++)
                if(num[j] < num[min]) min = j;
            
            if(min != i){
                int tmp = num[min];
                num[min] = num[i];
                num[i] = tmp;
            }
            System.out.println(num[i]);
        }
        System.out.println(num[N-1]);
    }
}
