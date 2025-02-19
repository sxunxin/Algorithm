import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    // 트리의 지름 - https://www.acmicpc.net/problem/1167

    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int node, max = 0;

    static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, c));
            }
        }

        dfs(1, 0);
        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if (!visited[n.e]) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }

    }
}
