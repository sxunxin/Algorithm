import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 연속합 - https://www.acmicpc.net/problem/1912

    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        func(N - 1);
        System.out.println(max);
    }

    public static int func(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(func(n-1) + arr[n], arr[n]);
            max = Math.max(max, dp[n]);
        }
        return dp[n];
    }

}
