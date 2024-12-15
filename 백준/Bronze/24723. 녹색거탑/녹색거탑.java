import java.util.Scanner;

public class Main {
    // 녹색거탑 - https://www.acmicpc.net/problem/24723
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println((int)Math.pow(2, N));
    }
}
