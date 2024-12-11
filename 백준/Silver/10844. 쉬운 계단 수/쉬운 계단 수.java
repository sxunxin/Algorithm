
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 쉬운 계단 수 - https://www.acmicpc.net/problem/10844

    public static Long[][] dp;
    public static int N;
    final public static long DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];
        long sum = 0;

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        for (int i = 1; i < 10; i++) {
            sum += func(N, i);
        }
        System.out.println(sum % DIV);
    }

    public static long func(int N, int A) {
        if (N == 1) {
            return dp[N][A];
        }
        
        if (dp[N][A] == null) {
            if (A == 0) {
                dp[N][A] = func(N - 1, 1);
            } else if (A == 9) {
                dp[N][A] = func(N - 1, 8);
            } else {
                dp[N][A] = func(N - 1, A - 1) + func(N - 1, A + 1);
            }
        }
        return dp[N][A] % DIV;
    }
}
