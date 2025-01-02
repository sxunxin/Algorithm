import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 바이러스 - https://www.acmicpc.net/problem/2606

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] checked;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        checked = new boolean[N + 1];

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

        bfs(1);

        System.out.println(cnt);
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        checked[idx] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < graph.get(p).size(); i++) {
                int next = graph.get(p).get(i);
                if (!checked[next]) {
                    q.add(next);
                    checked[next] = true;
                    cnt++;
                }
            }
        }
    }
}
