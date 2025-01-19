import java.io.*;
import java.util.*;

public class Main {
    // 최단경로 - https://www.acmicpc.net/problem/1753

    static ArrayList[] list;
    static int[] res;

    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        res = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<Node>();
            res[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (res[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
    }
}