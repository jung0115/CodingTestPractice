//백준 > 단계별로 풀어보기 > 브루트 포스 > 수 정렬하기 2(2751)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Num2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 0; i < N; i++)
            num.add(i, Integer.parseInt(bf.readLine()));

        Collections.sort(num); //Timsort

        StringBuilder printSet = new StringBuilder();
        for(int set : num)
            printSet.append(set).append("\n");
        System.out.print(printSet);
    }
}