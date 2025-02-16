import java.io.*;
import java.util.*;

public class Main {
    // 최소비용 구하기 - https://www.acmicpc.net/problem/1916

    static ArrayList<ArrayList<Node>> list;
    static int[] res;
    static boolean[] check;

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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        res = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            res[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity, endCity);
        System.out.println(res[endCity]);
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        res[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node nNode = pq.poll();

            int now = nNode.v;
            if (!check[now]) {
                check[now] = true;

                for (Node node : list.get(now)) {
                    if (!check[node.v] && res[node.v] > res[now] + node.w) {
                        res[node.v] = res[now] + node.w;
                        pq.add(new Node(node.v, res[node.v]));
                    }
                }
            }
        }
    }
}
