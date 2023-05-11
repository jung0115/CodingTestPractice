//바이러스(2606)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Num2606 {
    static int[][] network;
    static boolean[] check;
    static int cnt = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int computerN = Integer.parseInt(bf.readLine());
        int networkN = Integer.parseInt(bf.readLine());

        network = new int[computerN + 1][computerN + 1];
        check = new boolean[computerN + 1];

        for(int i = 0; i < networkN; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            network[x][y] = network[y][x] = 1;
        }
        
        Virus(1, computerN);

        System.out.print(cnt);
    }
    static void Virus(int start, int computerN) {
        check[start] = true;
        cnt++;

        for(int i = 1; i <= computerN; i++) {
            if(network[start][i] == 1 && check[i] == false) {
                Virus(i, computerN);
            }
        }
    }
}
