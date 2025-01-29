import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 타임머신 - https://www.acmicpc.net/problem/11657

    static int N, M;
    static ArrayList<ArrayList<Node>> arr;
    static long[] dist;
    static final int INF = 987654321;

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr.get(A).add(new Node(B, C));
        }

        if (bellmanFord()) {
            sb.append("-1").append("\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Node node : arr.get(j)) {
                    if (dist[j] == INF) break;

                    if (dist[node.end] > dist[j] + node.weight) {
                        dist[node.end] = dist[j] + node.weight;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node node : arr.get(i)) {
                    if (dist[i] == INF) break;
                    if (dist[node.end] > dist[i] + node.weight) return true;
                }
            }
        }
        return false;
    }
}
