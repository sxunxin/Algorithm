import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 최소비용 구하기 2 - https://www.acmicpc.net/problem/11779

    static ArrayList<ArrayList<Node>> list;
    static int[] res;
    static boolean[] check;
    static int[] visited;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        res = new int[N + 1];
        check = new boolean[N + 1];
        visited = new int[N + 1];

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

        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(endCity);
        while (visited[endCity] != 0) {
            cnt++;
            stack.push(visited[endCity]);
            endCity = visited[endCity];
        }
        System.out.println(cnt);
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
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
                        visited[node.v] = now;
                        pq.add(new Node(node.v, res[node.v]));
                    }
                }
            }
        }
    }
}
