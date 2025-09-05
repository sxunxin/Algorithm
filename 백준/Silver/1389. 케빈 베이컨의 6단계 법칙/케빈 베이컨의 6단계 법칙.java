import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 케빈 베이컨의 6단계 법칙 - https://www.acmicpc.net/problem/1389

    static int N, M;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            list[point1].add(point2);
            list[point2].add(point1);
        }

        int minCnt = Integer.MAX_VALUE;
        int minId = 0;
        for (int i = 1; i <= N; i++) {
            int nowCnt = bfs(i);
            if (minCnt > nowCnt) {
                minCnt = nowCnt;
                minId = i;
            }
        }

        System.out.println(minId);
    }

    public static int bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);

        int sum = 0;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[idx] = 0;


        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);

                if (dist[next] == -1) {
                    queue.add(next);
                    dist[next] = dist[now] + 1;
                    sum += dist[next];
                }
            }
        }

        return sum;
    }
}
