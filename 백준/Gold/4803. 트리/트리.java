import java.io.*;
import java.util.*;

public class Main {
    // 트리 - https://www.acmicpc.net/problem/4803

    static List<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testcase = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            list = new ArrayList<>();
            visited = new boolean[N + 1];

            for (int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            int tree = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    tree += checkTree(i);
                }
            }

            sb.append("Case ").append(testcase++).append(": ");
            if (tree > 1) sb.append("A forest of ").append(tree).append(" trees.");
            else if (tree == 1) sb.append("There is one tree.");
            else sb.append("No trees.");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int checkTree(int root) {
        Queue<Integer> queue = new LinkedList<>();
        int node = 0;
        int edge = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            if (visited[nowNode]) continue;
            visited[nowNode] = true;
            node++;

            for (int i = 0; i < list.get(nowNode).size(); i++) {
                int nextNode = list.get(nowNode).get(i);
                edge++;
                if (!visited[nextNode]) queue.add(nextNode);
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;
    }
}
