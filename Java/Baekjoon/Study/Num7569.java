//토마토(7569) _ 3차원
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Num7569 {
    static int[][][] tomato;
    static int day = -1;
    static int M, N, H;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); //가로 칸의 수
        N = Integer.parseInt(st.nextToken()); //세로 칸의 수
        H = Integer.parseInt(st.nextToken()); //상자 층 수

        tomato = new int[H][N][M];
        int cnt = 0;
        for(int i = 0; i < N*H; i++) {
            StringTokenizer str = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                tomato[cnt][i%N][j] = Integer.parseInt(str.nextToken());
            }
            if((i+1)%N == 0) cnt++;
        }
        
        Queue<Integer> queZ = new LinkedList<Integer>();
        Queue<Integer> queY = new LinkedList<Integer>();
        Queue<Integer> queX = new LinkedList<Integer>();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(tomato[i][j][k] == 1) {
                        queZ.offer(i);
                        queY.offer(j);
                        queX.offer(k);
                    }
                }
            }
        }

        growTomato(queX, queY, queZ);

        if(checkAll())
            System.out.print(day);
        else
            System.out.print(-1);

    }
    static void growTomato(Queue<Integer> queX, Queue<Integer> queY, Queue<Integer> queZ) {
        if(queX.isEmpty()) return;

        day++;

        Queue<Integer> newQueZ = new LinkedList<Integer>(); //H
        Queue<Integer> newQueY = new LinkedList<Integer>(); //N
        Queue<Integer> newQueX = new LinkedList<Integer>(); //M

        while(!queX.isEmpty()) {
            int z = queZ.poll();
            int y = queY.poll();
            int x = queX.poll();

            if(x+1 < M && tomato[z][y][x+1] == 0) {
                newQueZ.offer(z);
                newQueY.offer(y);
                newQueX.offer(x+1);
                tomato[z][y][x+1] = 1;
            }
            if(x-1 >= 0 && tomato[z][y][x-1] == 0) {
                newQueZ.offer(z);
                newQueY.offer(y);
                newQueX.offer(x-1);
                tomato[z][y][x-1] = 1;
            }
            if(y+1 < N && tomato[z][y+1][x] == 0) {
                newQueZ.offer(z);
                newQueY.offer(y+1);
                newQueX.offer(x);
                tomato[z][y+1][x] = 1;
            }if(y-1 >= 0 && tomato[z][y-1][x] == 0) {
                newQueZ.offer(z);
                newQueY.offer(y-1);
                newQueX.offer(x);
                tomato[z][y-1][x] = 1;
            }if(z+1 < H && tomato[z+1][y][x] == 0) {
                newQueZ.offer(z+1);
                newQueY.offer(y);
                newQueX.offer(x);
                tomato[z+1][y][x] = 1;
            }if(z-1 >= 0 && tomato[z-1][y][x] == 0) {
                newQueZ.offer(z-1);
                newQueY.offer(y);
                newQueX.offer(x);
                tomato[z-1][y][x] = 1;
            }
        }

        growTomato(newQueX, newQueY, newQueZ);
    }
    static boolean checkAll() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(tomato[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }
}
