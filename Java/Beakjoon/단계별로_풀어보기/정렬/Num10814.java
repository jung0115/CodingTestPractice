//백준 > 단계별로 풀어보기 > 정렬 > 나이순 정렬(10814)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
public class Num10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[][] people = new String[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            people[i][0] = st.nextToken();
            people[i][1] = st.nextToken();
        }

        Arrays.sort(people, (person1, person2) -> {
            int age1, age2;
            age1 = Integer.parseInt(person1[0]);
            age2 = Integer.parseInt(person2[0]);
            if(age1 == age2)
                return 0;
            else
                return age1 - age2;
        });

        StringBuilder printSet = new StringBuilder();
        for(int i = 0; i < N; i++)
            printSet.append(people[i][0]).append(" ").append(people[i][1]).append("\n");
        System.out.println(printSet);
    }
}
