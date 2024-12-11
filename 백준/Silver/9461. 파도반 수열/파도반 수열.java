import java.util.Scanner;

public class Main {
    // 파도반 수열 - https://www.acmicpc.net/problem/9461

    static Long[] dp = new Long[101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(pado(n));
        }
    }

    static long pado(int n) {
        if (dp[n] == null) {
            dp[n] = pado(n - 3) + pado(n - 2);
        }
        return dp[n];
    }
}
