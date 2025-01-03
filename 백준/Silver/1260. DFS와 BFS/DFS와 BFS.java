import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // DFS와 BFS - https://www.acmicpc.net/problem/1260

    public static int cnt;
    public static int[] checked;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        checked = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;

        dfs(R);

        sb.append('\n');
        checked = new int[N + 1];

        bfs(R);

        System.out.println(sb);
    }

    public static void dfs(int node) {

        checked[node] = cnt;
        sb.append(node).append(" ");

        for (int i = 0; i < graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);
            if (checked[newNode] == 0) {
                cnt++;
                dfs(newNode);
            }
        }

    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        checked[node] = 1;
        sb.append(node).append(" ");

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < graph.get(p).size(); i++) {
                int next = graph.get(p).get(i);
                if (checked[next] == 0) {
                    q.add(next);
                    checked[next] = 1;
                    sb.append(next).append(" ");
                }
            }
        }
    }
}
