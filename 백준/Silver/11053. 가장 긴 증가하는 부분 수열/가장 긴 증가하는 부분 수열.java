import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 증가하는 부분 수열 - https://www.acmicpc.net/problem/11053

    public static int[] arr;
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            func(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static int func(int N) {
        if (dp[N] == null) {
            dp[N] = 1;

            for (int i = N-1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], func(i) + 1);
                }
            }
        }

        return dp[N];
    }
}
