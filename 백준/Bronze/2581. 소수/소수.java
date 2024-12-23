import java.util.Scanner;

public class Main {
    // 소수 - https://www.acmicpc.net/problem/2581
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int sum = 0;
        int min = 0;

        for (int i = M; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i != 1) {
                sum += i;
                if (min == 0) min = i;
            }
        }

        if (sum == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
