
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 1로 만들기 - https://www.acmicpc.net/problem/1463

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(Make1(N));
    }

    static int Make1(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(Make1(N / 3), Math.min(Make1(N / 2), Make1(N - 1))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(Make1(N / 3), Make1(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(Make1(N / 2), Make1(N - 1)) + 1;
            } else {
                dp[N] = Make1(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
