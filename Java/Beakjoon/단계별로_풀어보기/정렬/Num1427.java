//백준 > 단계별로 풀어보기 > 정렬 > 소트인사이드(1427)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Num1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int len = 0;
        for(int i = 0; N > 0; i++) {
            nums.add(i, N%10);
            N /= 10;
            len++;
        }

        Collections.sort(nums); //Timsort

        StringBuilder printSet = new StringBuilder();
        for(int i = len-1; i >= 0; i--)
            printSet.append(nums.get(i));

        System.out.print(printSet);
    }
}
