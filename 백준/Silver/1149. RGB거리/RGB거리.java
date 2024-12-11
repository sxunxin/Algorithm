import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // RGB거리 - https://www.acmicpc.net/problem/1149

    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        System.out.println(Math.min(func(N-1,0), Math.min(func(N - 1, 1), func(N - 1, 2))));
    }

    public static int func(int n, int color) {

        if (dp[n][color] == 0) {
            if (color == 0) dp[n][0] = Math.min(func(n - 1, 1), func(n - 1, 2)) + arr[n][0];
            else if (color == 1) dp[n][1] = Math.min(func(n - 1, 0), func(n - 1, 2)) + arr[n][1];
            else if (color == 2) dp[n][2] = Math.min(func(n - 1, 0), func(n - 1, 1)) + arr[n][2];
        }
        return dp[n][color];
    }
}
