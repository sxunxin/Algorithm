import java.util.Scanner;

public class Main {
    // 알고리즘 수업 - 점근적 표기 1 - https://www.acmicpc.net/problem/24313

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a1 = scanner.nextInt();
        double a2 = scanner.nextInt();
        double c = scanner.nextInt();
        double n = scanner.nextInt();

        if (a1*n + a2 <= c*n && a1 <= c)
            System.out.println(1);
        else
            System.out.println(0);

    }
    
}
