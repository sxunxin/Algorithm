import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 다리 놓기 - https://www.acmicpc.net/problem/1010

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combi(M, N)).append('\n');

        }

        System.out.println(sb);
    }

    static int combi(int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];

        if (n == r || r == 0)
            return dp[n][r] = 1;

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

}
