// Samsung SW Expert Academy - 1242. 암호코드 스캔
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class SWEA_1242 {
  static int[][] hexCode = {
    {0, 0, 0, 0}, // 0
    {0, 0, 0, 1}, // 1
    {0, 0, 1, 0}, // 2
    {0, 0, 1, 1}, // 3
    {0, 1, 0, 0}, // 4
    {0, 1, 0, 1}, // 5
    {0, 1, 1, 0}, // 6
    {0, 1, 1, 1}, // 7
    {1, 0, 0, 0}, // 8
    {1, 0, 0, 1}, // 9
    {1, 0, 1, 0}, // A
    {1, 0, 1, 1}, // B
    {1, 1, 0, 0}, // C
    {1, 1, 0, 1}, // D
    {1, 1, 1, 0}, // E
    {1, 1, 1, 1}, // F
  };

  static int[][] map;
  static int[][][] rate = new int[5][5][5];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder printSet = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
    
    init(); // 코드 0, 1의 비율에 따라 어떤 값인지 세팅

		for(int test_case = 1; test_case <= T; test_case++) {
      // 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      // 입력 받으면서 바로 2진수로 변환
      map = new int[N][M * 4];
      for(int i = 0; i < N; i++) {
        String input = br.readLine();
        for(int j = 0; j < M; j++) {
          char hex16 = input.charAt(j);
          int hex2 = Character.digit(hex16, 16);
          for(int k = 0; k < 4; k++) {
            map[i][j * 4 + k] = hexCode[hex2][k];
          }
        }
      }

			int answer = 0;
      int codeIdx = 7; // 현재 코드의 몇 번째 자리를 체크 중인지
      int[] code = new int[8]; // 암호코드
      for(int i = 0; i < N; i++) {
        // 뒤에서부터 탐색
        for(int j = M * 4 - 1; j >= 0; j--) {
          // 암호코드의 시작 부분 + 이전에 탐색한 암호코드가 아님
          if(map[i][j] == 1 && map[i-1][j] == 0) {
            int x = 0, y = 0, z = 0;
            
            // ? : x : y : z
            while (map[i][j] == 1) { z++; j--; } // 맨뒤 1의 개수
            while (map[i][j] == 0) { y++; j--; } // 중간 0의 개수
            while (map[i][j] == 1) { x++; j--; } // 첫 1의 개수

            // 앞에 남아있는 0들을 다 건너뛰어주기
            if (codeIdx != 0) { while (map[i][j] == 0) { j--; } }
            j++;
            
            // 두께를 1로 만들기 위한 작업
            int depth = Math.min(x, Math.min(y, z));
            code[codeIdx--] = rate[x / depth][y / depth][z / depth];

            // 암호코드 8자리 별견
            if(codeIdx == -1) {
              // (홀수 자리의 합 x 3) + 짝수 자리의 합 + 검증 코드
              int value = 0;
              for(int k = 0; k < 8; k++) {
                if(k % 2 == 0) // 홀수자리 (인덱스상으로는 짝수)
                  value += code[k] * 3;
                else  // 짝수자리 (인덱스상으로는 홀수) or 검증 코드
                  value += code[k];
              }

              // 10의 배수인지 확인 -> 해당 암호코드에 적혀있는 숫자들의 합 누적
              if(value % 10 == 0) {
                for(int c : code) answer += c;
              }
              
              codeIdx = 7; // 새로운 코드 체크를 위해 초기화
            }
          }
        }
      }


      printSet.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
    System.out.print(printSet);
	}

  // 코드 0, 1의 비율에 따라 어떤 값인지 세팅
  private static void init() {
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < 5; k++)
          rate[i][j][k] = -1;

    rate[2][1][1] = 0; // 2:1:1
    rate[2][2][1] = 1; // 2:2:1
    rate[1][2][2] = 2; // 1:2:2
    rate[4][1][1] = 3; // 4:1:1
    rate[1][3][2] = 4; // 1:3:2
    rate[2][3][1] = 5; // 2:3:1
    rate[1][1][4] = 6; // 1:1:4
    rate[3][1][2] = 7; // 3:1:2
    rate[2][1][3] = 8; // 2:1:3
    rate[1][1][2] = 9; // 1:1:2
  }
}