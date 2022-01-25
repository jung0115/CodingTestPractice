//백준 > 단계별로 풀어보기 > 정렬 > 수 정렬하기 3(10989)
package Java.Beakjoon.단계별로_풀어보기.정렬;

//Counting sort 방식으로
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Num10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(bf.readLine());
        
        int[] count = new int[10001];
        int max = 0;
        //기본적으로 java는 int 배열이 0으로 초기화 됨.
        for(int n : nums) {
            count[n]++;
            if(n > max) max = n;
        }
        for(int i = 1; i <= max; i++)
            count[i] += count[i-1];
        
        int[] setNums = new int[N];
        for(int i = N-1; i >= 0; i--) {
            int n = nums[i];
            count[n]--;
            setNums[count[n]] = n;
        }
        
        StringBuilder printSet = new StringBuilder();
        for(int set : setNums)
            printSet.append(set).append("\n");
        System.out.print(printSet);
    }
}
