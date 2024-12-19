import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 양팔저울 - https://www.acmicpc.net/problem/2629

    public static int[] W;
    public static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        W = new int[N];
        dp = new boolean[N + 1][40001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int marbles = Integer.parseInt(st.nextToken());
            System.out.print(dp[N][marbles] ? "Y " : "N ");
        }
    }

    public static void recur(int cnt, int num) {
        if (dp[cnt][num]) return;
        dp[cnt][num] = true;

        if (cnt == W.length) return;

        recur(cnt + 1, num + W[cnt]);
        recur(cnt + 1, num);
        recur(cnt + 1, Math.abs(num - W[cnt]));
    }
}
