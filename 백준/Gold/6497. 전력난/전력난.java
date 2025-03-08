import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 전력난 - https://www.acmicpc.net/problem/6497

    static int[] parent;
    static ArrayList<Node> list;

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) break;

            int value = 0;
            parent = new int[M + 1];
            list = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                value += v;
                list.add(new Node(a, b, v));
            }
            Collections.sort(list);

            int sum = 0;
            int cnt = 0;
            for (Node n : list) {
                if (union(n.from, n.to)) {
                    sum += n.value;
                    cnt++;

                    if (cnt + 1 == M) break;
                }
            }
            System.out.println(value - sum);
        }
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        else parent[b] = a;
        return true;
    }

    public static int find(int v) {
        if (v == parent[v]) return v;
        else return parent[v] = find(parent[v]);
    }
}
