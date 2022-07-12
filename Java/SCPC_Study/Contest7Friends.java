// SCPC 7회 예선 - 친구들
// 점수: 30 / 80

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Contest7Friends {
	static int Answer;
    static int[] check;
	public static void main(String args[]) throws Exception, IOException	{
		//Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		//int T = sc.nextInt();
		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

            // 입력
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] people = new int[N];
			for(int i = 0; i < N; i++) {
			    people[i] = Integer.parseInt(st.nextToken());
			}

            check = new int[N];
            int checkNum = 0;
            for(int i = 0; i < N; i++) {
                if(check[i] == 0) {
                    checkNum++;
                    check[i] = checkNum;
                }
                if((i+people[i]) < N) {
                    if(check[i+people[i]] == 0) {
                        check[i+people[i]] = check[i];
                    }
                    else {
                        setNewGroup(check[i], check[i+people[i]], N);
                    }
                }
            }

            int[] countCheck = new int[N];
            for(int i = 0; i < N; i++) {
                if(countCheck[check[i]-1] == 0) {
                    countCheck[check[i]-1] = 1;
                    Answer++;
                }
            }

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

    static public void setNewGroup(int preNum, int newNum, int N) {
        for(int i = 0; i < N; i++) {
            if(check[i] == preNum) {
                check[i] = newNum;
            }
        }
    }
}