import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 특정한 최단 경로 - https://www.acmicpc.net/problem/1504

    static ArrayList[] list;
    static int[] res;
    static int V, E;
    static int MAX = 200000000;

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        res = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<Node>();
            res[i] = MAX;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        int target3 = V;

        int res1 = 0;
        res1 += dijkstra(1, target1);
        res1 += dijkstra(target1, target2);
        res1 += dijkstra(target2, target3);

        int res2 = 0;
        res2 += dijkstra(1, target2);
        res2 += dijkstra(target2, target1);
        res2 += dijkstra(target1, target3);

        if (res1 >= MAX && res2 >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    public static int dijkstra(int start, int targer) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i <= V; i++) {
            res[i] = MAX;
        }
        res[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node nNode = pq.poll();
            int len = list[nNode.v].size();
            for (int i = 0; i < len; i++) {
                Node nextNode = (Node) list[nNode.v].get(i);

                if (res[nextNode.v] > nNode.w + nextNode.w) {
                    res[nextNode.v] = nNode.w + nextNode.w;
                    pq.add(new Node(nextNode.v, res[nextNode.v]));
                }
            }
        }
        return res[targer];
    }
}