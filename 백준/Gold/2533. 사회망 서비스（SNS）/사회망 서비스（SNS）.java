import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 사회망 서비스(SNS) - https://www.acmicpc.net/problem/2533

    static int[][] dp;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        dp = new int[2][N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1, 0);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    public static void dfs(int now, int pre) {
        dp[0][now] = 0;
        dp[1][now] = 1;

        ArrayList<Integer> dfsList = list.get(now);
        for (Integer next : dfsList) {
            if (pre == next) continue;

            dfs(next, now);
            dp[0][now] += dp[1][next];
            dp[1][now] += Math.min(dp[0][next], dp[1][next]);
        }
    }
}
