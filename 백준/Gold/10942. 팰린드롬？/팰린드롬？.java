import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 팰린드롬? - https://www.acmicpc.net/problem/10942

    static boolean[][] dp;
    static int N, M;
    static int[] arr;
    static Node[] questions;

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new boolean[N + 1][N + 1];
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        questions = new Node[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            questions[i] = new Node(start, end);
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
            if (i < N)
                dp[i][i + 1] = (arr[i] == arr[i + 1]);
        }

        for (int j = 2; j < N; j++) {
            for (int i = 1; i <= N; i++) {
                if (i + j <= N)
                    dp[i][i + j] = (arr[i] == arr[i + j] && dp[i + 1][i + j - 1]);
            }
        }

        for (Node node : questions) {
            if (dp[node.start][node.end]) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}
