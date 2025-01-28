import java.io.*;
import java.util.*;

public class Main {
    // 미확인 도착지 - https://www.acmicpc.net/problem/9370

    static final int INF = 10_000_000;
    static int n, m, t, s, g, h;
    static int[][] arr;
    static int[] dist;
    static boolean[] check;
    static List<Integer> answerList;

    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            arr = new int[n + 1][n + 1];
            dist = new int[n + 1];

            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(arr[i], INF);
            }
            Arrays.fill(dist, INF);
            check = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arr[p1][p2] = arr[p2][p1] = d * 2;
            }
            arr[h][g] = arr[g][h] = arr[h][g] - 1;

            answerList = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                answerList.add(Integer.parseInt(br.readLine()));
            }

            dijkstra();

            Collections.sort(answerList);
            for (int num : answerList) {
                if (dist[num] % 2 == 1) sb.append(num).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));
        dist[s] = 0;

        while (!q.isEmpty()) {
            Node nNode = q.poll();
            int now = nNode.end;

            if (check[now]) continue;
            check[now] = true;

            for (int i = 1; i <= n; i++) {
                if (!check[i] && dist[i] > dist[now] + arr[now][i]) {
                    dist[i] = dist[now] + arr[now][i];
                    q.add(new Node(i, dist[i]));
                }
            }
        }
    }
}
