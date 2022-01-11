//백준 > 단계별로 풀어보기 > 브루트 포스 > 블랙잭(2798)
package Java.Beakjoon.단계별로_풀어보기.브루트_포스;

import java.util.Scanner;
public class Num2798 {
    public static void main(String[] args) {
        int N, M;
        int[] card_number;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        card_number = new int[N];
        for(int i = 0; i < N; i++)
            card_number[i] = scan.nextInt();

        scan.close();

        int sum, answer = 0;
        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    sum = card_number[i] + card_number[j] + card_number[k];
                    if(sum <= M && sum > answer) answer = sum;
                }
            }
        }

        System.out.println(answer);
    }
}
