import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 쉬운 최단거리 - https://www.acmicpc.net/problem/14940

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int targetX = 0;
        int targetY = 0;

        arr = new int[N][M];
        visited = new boolean[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                } else if (arr[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(targetX, targetY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) result[i][j] = -1;
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    result[nx][ny] = result[now[0]][now[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
