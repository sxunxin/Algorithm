import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // ACM Craft - https://www.acmicpc.net/problem/1005

    static int[] cost;
    static int[] child;
    static int[] totalCost;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            cost = new int[N + 1];
            child = new int[N + 1];
            totalCost = new int[N + 1];
            list = new ArrayList<>();
            list.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                list.add(new ArrayList<>());
                cost[i] = Integer.parseInt(st.nextToken());
                totalCost[i] = cost[i];
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                child[end]++;
                list.get(start).add(end);
            }

            int W = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (child[i] == 0) q.offer(i);
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : list.get(now)) {
                    totalCost[next] = Math.max(totalCost[next], totalCost[now] + cost[next]);
                    child[next]--;
                    if (child[next] == 0) q.offer(next);
                }
            }
            System.out.println(totalCost[W]);
        }
    }
}
