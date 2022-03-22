//백준 > 단계별로 풀어보기 > 입출력과 사칙연산 > ??!(10926)
import java.util.Scanner;
public class Num10926 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();

        StringBuilder printSet = new StringBuilder();
        printSet.append(id).append("??!");
        System.out.print(printSet);

        scan.close();
    }
}
