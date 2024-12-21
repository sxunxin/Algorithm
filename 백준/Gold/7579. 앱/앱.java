import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 앱 - https://www.acmicpc.net/problem/7579

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memoryArr = new int[N];
        int[] costArr = new int[N];
        int[][] dp = new int[N][10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) memoryArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) costArr[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= costArr[i]) dp[i][j] = memoryArr[i];
                }
                else {
                    if (j >= costArr[i])
                        dp[i][j] = Math.max(dp[i - 1][j - costArr[i]] + memoryArr[i], dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= M) min = Math.min(min, j);
            }
        }
        System.out.println(min);
    }
}
