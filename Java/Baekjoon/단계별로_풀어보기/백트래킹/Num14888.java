//백준 > 단계별로 풀어보기 > 백트래킹 > 연산자 끼워넣기(14888)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Num14888 {
    static int max = -1000000000; //최대
    static int min = 1000000000; //최소
    static int[] nums; //수열
    static int[] operators = new int[4]; //연산자
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) //수열
            nums[i] = Integer.parseInt(st1.nextToken());
        for(int i = 0; i < 4; i++) //연산자
            operators[i] = Integer.parseInt(st2.nextToken());
        
        calculation(N, 1, nums[0]);

        StringBuilder printSet = new StringBuilder();
        printSet.append(max).append("\n").append(min);
        System.out.print(printSet);
    }
    static void calculation(int N, int cnt, int cal) {
        if(cnt == N) { //계산이 끝났을 때
            if(max < cal) max = cal; //최대값보다 큰 수일 경우
            if(min > cal) min = cal; //최소값보다 작은 수일 경우
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] == 0) continue; //해당 연산자를 모두 사용했거나 할당되지 않은 경우
            operators[i]--;
            int setCal = calculate(cal, nums[cnt], i);
            calculation(N, cnt+1, setCal);
            operators[i]++;
        }
    }
    static int calculate(int cal, int num, int operator) {
        if(operator == 0) return cal + num;
        if(operator == 1) return cal - num;
        if(operator == 2) return cal * num;
        return cal / num;
    }
}
