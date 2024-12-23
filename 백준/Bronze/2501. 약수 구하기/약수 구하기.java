import java.util.Scanner;

public class Main {
    // 약수 구하기 - https://www.acmicpc.net/problem/2501
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int cnt = 0;
        for (int i = N; i >= 1; i--) {
            if (N % i == 0) {
                cnt++;
                if (cnt == K) {
                    System.out.println(N / i);
                    return;
                }
            }
        }
        System.out.println("0");
    }
}
