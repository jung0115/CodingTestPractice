//백준 > 단계별로 풀어보기 > 기본 수학2 > 터렛(1002)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
public class Num1002 {
    public static void main(String[] args) {
        int T;
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        for(int i = 0; i < T; i++) {
            int x1, x2, y1, y2, r1, r2;
            x1 = scan.nextInt(); y1 = scan.nextInt(); r1 = scan.nextInt();
            x2 = scan.nextInt(); y2 = scan.nextInt(); r2 = scan.nextInt();
            
            int cnt;
            cnt = checkSpace(x1, y1, r1, x2, y2, r2);
            System.out.println(cnt);
        }
        scan.close();
    }
    static int checkSpace(int x1, int y1, int r1, int x2, int y2, int r2) {
        if(x1 == x2 && y1 == y2 && r1 == r2) return -1;

        int len, rSum, rSub;
        //len: 조규현과 백승환의 거리의 제곱
        //rSum: 조규현, 백승환 각각 류재명과의 거리를 합한 값의 제곱
        //rSub: 조규현, 백승환 각각 류재명과의 거리를 뺀 값의 제곱
        len = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
        rSum = (r1 + r2)*(r1 + r2);
        rSub = (r1 - r2)*(r1 - r2);

        if(len > rSum || len < rSub) return 0;
        if(len == rSum || len == rSub) return 1;
        return 2;
    }
}
