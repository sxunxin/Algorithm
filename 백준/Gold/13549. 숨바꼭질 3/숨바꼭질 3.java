import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 숨바꼭질 3 - https://www.acmicpc.net/problem/13549

    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];

        bfs(N);

        System.out.println(arr[M]);
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int p = q.poll();

            if (p == M) return;

            if ((p * 2 <= 100000) && !visited[p * 2]) {
                q.offer(p * 2);
                visited[p * 2] = true;
                arr[p * 2] = arr[p];
            }

            if ((p - 1 >= 0) && !visited[p - 1]) {
                q.offer(p - 1);
                visited[p - 1] = true;
                arr[p - 1] = arr[p] + 1;
            }

            if ((p + 1 <= 100000) && !visited[p + 1]) {
                q.offer(p + 1);
                visited[p + 1] = true;
                arr[p + 1] = arr[p] + 1;
            }

        }
    }
}

