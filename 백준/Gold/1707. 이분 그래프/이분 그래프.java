import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 이분 그래프 - https://www.acmicpc.net/problem/1707

    static List<List<Integer>> graph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[V + 1];

            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean res = false;
            for (int j = 1; j <= V; j++) {
                if (colors[j] == 0) {
                    res = bfs(j, 1);
                }
                if (!res) break;
            }
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean bfs(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        colors[start] = color;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (colors[cur] == colors[next]) return false;

                if (colors[next] == 0) {
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
