import java.util.Scanner;

public class Main {
    // 베라의 패션 - https://www.acmicpc.net/problem/15439

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(N * (N-1));
    }
}
