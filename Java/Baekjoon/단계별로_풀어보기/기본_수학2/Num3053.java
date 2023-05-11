//백준 > 단계별로 풀어보기 > 기본 수학2 > 택시 기하학(3053)
package Java.Beakjoon.단계별로_풀어보기.기본_수학2;

import java.util.Scanner;
import java.lang.Math;
public class Num3053 {
    public static void main(String[] args) {
        int R;
        Scanner scan = new Scanner(System.in);
        R = scan.nextInt();
        scan.close();

        double Euclidean, Taxi;
        Euclidean = R*R*Math.PI;
        Taxi = R*R*2;

        System.out.println(Euclidean);
        System.out.println(Taxi);
    }
}