import java.util.Scanner;

public class Main {
    // 소인수분 - https://www.acmicpc.net/problem/11653
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while (N != 1) {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    System.out.println(i);
                    N /= i;
                    break;
                }
            }
        }
    }
}
