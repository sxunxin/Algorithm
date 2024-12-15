import java.util.Scanner;

public class Main {
    // 이항 계수 - https://www.acmicpc.net/problem/11050
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int ans = factorial(N)/(factorial(K) * factorial(N-K));
        System.out.println(ans);
    }

    public static int factorial(int num) {
        int result = 1;
        for(int i = 2; i <= num; i++) {
            result = result * i;
        }
        return result;
    }
}
