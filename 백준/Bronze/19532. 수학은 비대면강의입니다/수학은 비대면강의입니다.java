import java.util.Scanner;

public class Main {
    // 수학은 비대면강의입니다 - https://www.acmicpc.net/problem/19532
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();

        System.out.print((c*e- b*f) / (a*e - b*d) + " ");
        System.out.println((c*d - a*f) / (b*d - a*e));
    }
}
