import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 연결 요소의 개수 - https://www.acmicpc.net/problem/11724

    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pos1 = Integer.parseInt(st.nextToken());
            int pos2 = Integer.parseInt(st.nextToken());

            graph[pos1][pos2] = graph[pos2][pos1] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int idx) {
        if (visited[idx]) return;

        visited[idx] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[idx][i]) dfs(i);
        }
    }
}
