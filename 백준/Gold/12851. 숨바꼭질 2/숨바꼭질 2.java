import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 숨바꼭질 2 - https://www.acmicpc.net/problem/12851

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        cnt = new int[100001];
        visited = new boolean[100001];

        bfs(N);

        System.out.println(arr[M]);
        System.out.println(cnt[M]);
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;
        cnt[idx] = 1;

        while (!q.isEmpty()) {
            int p = q.poll();
            if (p == M) return;

            for (int next : new int[]{p - 1, p + 1, p * 2}) {
                if (next < 0 || next > 100000) continue;

                if (arr[next] == 0 || arr[next] > arr[p] + 1) {
                    arr[next] = arr[p] + 1;
                    cnt[next] = cnt[p];
                    q.offer(next);
                } else if (arr[next] == arr[p] + 1) {
                    cnt[next] += cnt[p];
                }
            }
        }
    }
}
