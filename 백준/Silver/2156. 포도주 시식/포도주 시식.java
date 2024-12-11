import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 포도주 시식 - https://www.acmicpc.net/problem/2156

    public static int[] arr;
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1];

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        if (N > 1) dp[2] = arr[1] + arr[2];

        System.out.println(func(N));
    }

    public static int func(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(Math.max(func(N - 2), func(N - 3) + arr[N - 1]) + arr[N], func(N - 1));
        }

        return dp[N];
    }
}
