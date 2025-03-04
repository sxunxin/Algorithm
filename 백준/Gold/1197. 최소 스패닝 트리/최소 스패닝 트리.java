import java.io.*;
import java.util.*;

public class Main {
    // 최소 스패닝 트리 - https://www.acmicpc.net/problem/1197

    static int[] parent;
    static ArrayList<Node> list;

    static class Node implements Comparable<Node>{
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, c));
        }
        Collections.sort(list);

        int sum = 0;
        int cnt = 0;
        for (Node n : list) {
            if (union(n.from, n.to)) {
                sum += n.value;
                cnt++;

                if (cnt == E - 1) break;
            }
        }

        System.out.println(sum);
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

