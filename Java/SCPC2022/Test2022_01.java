import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

class Test2022_01 {
	static Long Answer;

	public static void main(String args[]) throws Exception, IOException {
		
		//Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); // TestCase 수

		//int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0L;
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			// input
			int N = Integer.parseInt(bf.readLine()); // 개미 마리의 수
			int antPosition[] = new int[N];
			int antValue[] = new int[N];
            int checkPosition[][] = new int[N][2];
			    
			// 개미의 위치
			StringTokenizer stP = new StringTokenizer(bf.readLine());
			for(int ant_posi = 0; ant_posi < N; ant_posi++) {
			    antPosition[ant_posi] = Integer.parseInt(stP.nextToken());
			}
			
			// 개미가 들고 있는 값
			StringTokenizer stV = new StringTokenizer(bf.readLine());
			for(int ant_val = 0; ant_val < N; ant_val++) {
			    antValue[ant_val] = Integer.parseInt(stV.nextToken());

                checkPosition[ant_val][0] = antValue[ant_val];
                checkPosition[ant_val][1] = ant_val;
			}
			
            // 오름차순 정렬
			Arrays.sort(checkPosition, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o1[0] - o2[0];
                }});
            
            // 최단 거리 합 계산
            for(int move_posi = 0; move_posi < N; move_posi++) {
                Answer += Math.abs(antPosition[checkPosition[move_posi][1]] - antPosition[move_posi]);
            }

			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}