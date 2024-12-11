import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 정수 삼각형 - https://www.acmicpc.net/problem/1932

    public static int[][] arr;
    public static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];
        arr[N-1][0] = Integer.parseInt(br.readLine());
        if (N == 1) dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[N-1-i][j] = Integer.parseInt(st.nextToken());
                if (i == N-1) dp[0][j] = arr[N-1-i][j];
            }
        }
        System.out.println(func(N-1, 0));
    }

    public static int func(int N, int A) {

        if (dp[N][A] == null) {
            dp[N][A] = arr[N][A] + Math.max(func(N-1, A), func(N-1, A+1));
        }
        return dp[N][A];
    }
}
