//백준 > 단계별로 풀어보기 > 입출력과 사칙연산 > 1998년생인 내가 태국에서는 2541년생?!(18108)
import java.util.Scanner;
public class Num18108 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();

        year -= 543;

        System.out.print(year);
    }
}
