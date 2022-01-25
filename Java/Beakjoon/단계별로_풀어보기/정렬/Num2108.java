//백준 > 단계별로 풀어보기 > 정렬 > 통계학(2108)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Num2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < N; i++)
            nums.add(i, Integer.parseInt(bf.readLine()));

        Collections.sort(nums); //Timsort
        
        double sum = 0;
        int[][] cnt = new int[2][2];
        boolean check = true;
        
        for(int n : nums) {
            sum += n;
            if(cnt[1][1] == 0 || cnt[1][0] == n) {
                cnt[1][0] = n;
                cnt[1][1]++;
            }
            else {
                if(cnt[0][1] < cnt[1][1]) {
                    check = true;
                    cnt[0][0] = cnt[1][0];
                    cnt[0][1] = cnt[1][1];
                }
                else if(cnt[0][1] == cnt[1][1] && check) {
                    check = false;
                    cnt[0][0] = cnt[1][0];
                    cnt[0][1] = cnt[1][1];
                }
                
                cnt[1][0] = n;
                cnt[1][1] = 1;
            }
        }
        if(cnt[0][1] < cnt[1][1] || (cnt[0][1] == cnt[1][1] && check)) {
            cnt[0][0] = cnt[1][0];
            cnt[0][1] = cnt[1][1];
        }

        StringBuilder printSet = new StringBuilder();

        printSet.append(Math.round(sum/N)).append("\n"); //산술평균
        printSet.append(nums.get(N/2)).append("\n"); //중앙값
        printSet.append(cnt[0][0]).append("\n"); //최빈값
        printSet.append(nums.get(N-1) - nums.get(0)); //범위

        System.out.print(printSet);
    }
}
