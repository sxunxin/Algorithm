import java.util.Scanner;

public class Main {
    // 소수 찾기 - https://www.acmicpc.net/problem/1978
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            boolean isPrime = true;
            int num = scanner.nextInt();

            for (int j = 2; j <= num/2; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num != 1) cnt++;
        }
        System.out.println(cnt);
    }
}
