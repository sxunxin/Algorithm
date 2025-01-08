import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    // 미로 탐색 - https://www.acmicpc.net/problem/2178

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(arr[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point nPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = nPoint.x + dx[i];
                int nY = nPoint.y + dy[i];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (arr[nX][nY] == 0) continue;
                if (visited[nX][nY]) continue;

                q.offer(new Point(nX, nY));
                visited[nX][nY] = true;

                arr[nX][nY] = arr[nPoint.x][nPoint.y] + 1;
            }
        }
    }
}
