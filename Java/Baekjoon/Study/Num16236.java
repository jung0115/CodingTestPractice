// 백준 - 아기 상어(16236)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Num16236 {
  static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 공간의 크기 N
    int N = Integer.parseInt(br.readLine());

    // 공간
    int[][] space = new int[N][N];
    // 아기상어의 위치
    Position pos = new Position(0, 0, 0);

    //  공간 상태 입력
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        space[i][j] = Integer.parseInt(st.nextToken());

        // 아기상어의 위치
        if(space[i][j] == 9) {
          pos.row = i;
          pos.col = j;
          space[i][j] = 0;
        }
      }
    }

    int moveTime = 0; // 이동한 거리
    int size = 2;     // 아기상어의 크기
    int eatFish = 0;  // 먹은 물고기의 수 -> 아기상어 성장 유무를 체크하기 위함

    while(true) {
      // 우선순위 큐를 이용헤서 먹을 물고기 순서를 결정
      PriorityQueue<Position> queue = new PriorityQueue<Position>((o1, o2) ->
        o1.time != o2.time ? Integer.compare(o1.time, o2.time)  // 시간이 다르면 가까운순
          : (o1.row != o2.row ? Integer.compare(o1.row, o2.row) // 시간 같으면 더 위에 있는순
            : Integer.compare(o1.col, o2.col))                  // 시간, 높이가 같으면 더 왼쪽에 있는순
      );

      queue.add(new Position(pos.row, pos.col, 0)); // 아기상어의 현재 위치

      boolean[][] visited = new boolean[N][N];
      visited[pos.row][pos.col] = true; // 방문 체크

      boolean checkAteFish = false; // 아기 상어가 먹이를 먹었는지 유무

      while (!queue.isEmpty()) {
        pos = queue.poll();

        // 아기상어보다 작은 먹이 = 먹을 수 있는 먹이
        if(space[pos.row][pos.col] != 0 && space[pos.row][pos.col] < size) {
          space[pos.row][pos.col] = 0; // 물고기 먹기
          eatFish++;

          moveTime += pos.time; // 이동시간 증가
          checkAteFish = true;  // 물고기 먹음
          break;
        }

        //  상하좌우 이동
        for(int i = 0; i < 4; i++) {
          int moveY = pos.row + dy[i];
          int moveX = pos.col + dx[i];

          // 공간 범위를 벗어나거나, 이미 방문했거나, 상어보다 큰 물고기가 있는 경우 패스
          if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N || visited[moveY][moveX] || space[moveY][moveX] > size)
            continue;
          
          queue.add(new Position(moveY, moveX, pos.time + 1));
          visited[moveY][moveX] = true;
        }
      }

      // 먹은 물고기가 없다 = 더이상 먹을 수 있는 물고기가 없다
      if(!checkAteFish)
        break;
    
      // 먹은 물고기의 수가 아기상어의 크기과 같다면, 아기상어의 크기 증가
      if(size == eatFish) {
        size++;
        eatFish = 0;
      }
    }

    System.out.println(moveTime);
    
  }

  private static class Position {
    int row, col, time;

    Position(int row, int col, int time) {
      this.row = row;
      this.col = col;
      this.time = time;
    }
  }
}
