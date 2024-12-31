import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 알고리즘 수업 - 너비 우선 탐색 1 - https://www.acmicpc.net/problem/24444

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] checked;
    public static int count = 1;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        checked = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;
        result[start] = count++;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < graph.get(p).size(); i++) {
                int next = graph.get(p).get(i);
                if (!checked[next]) {
                    q.add(next);
                    checked[next] = true;
                    result[next] = count++;
                }
            }
        }
    }
}
