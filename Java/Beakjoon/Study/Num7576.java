//토마토(7576)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Num7576 {
    static int[][] tomato;
    static int day = -1;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); //가로 칸의 수
        N = Integer.parseInt(st.nextToken()); //세로 칸의 수

        tomato = new int[N][M];
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Queue<Integer> queX = new LinkedList<Integer>();
        Queue<Integer> queY = new LinkedList<Integer>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 1) {
                    queX.offer(i);
                    queY.offer(j);
                }
            }
        }

        growTomato(queX, queY);

        if(checkAll())
            System.out.print(day);
        else
            System.out.print(-1);

    }
    static void growTomato(Queue<Integer> queX, Queue<Integer> queY) {
        if(queX.isEmpty()) return;

        day++;

        Queue<Integer> newQueX = new LinkedList<Integer>();
        Queue<Integer> newQueY = new LinkedList<Integer>();

        while(!queX.isEmpty()) {
            int x = queX.poll();
            int y = queY.poll();

            if(x+1 < N && tomato[x+1][y] == 0) {
                newQueX.offer(x+1);
                newQueY.offer(y);
                tomato[x+1][y] = 1;
            }
            if(x-1 >= 0 && tomato[x-1][y] == 0) {
                newQueX.offer(x-1);
                newQueY.offer(y);
                tomato[x-1][y] = 1;
            }
            if(y+1 < M && tomato[x][y+1] == 0) {
                newQueX.offer(x);
                newQueY.offer(y+1);
                tomato[x][y+1] = 1;
            }
            if(y-1 >= 0 && tomato[x][y-1] == 0) {
                newQueX.offer(x);
                newQueY.offer(y-1);
                tomato[x][y-1] = 1;
            }
        }

        growTomato(newQueX, newQueY);
    }
    static boolean checkAll() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) return false;
            }
        }

        return true;
    }
}
