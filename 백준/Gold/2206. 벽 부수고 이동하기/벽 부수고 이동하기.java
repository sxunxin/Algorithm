import java.io.*;
import java.util.*;

public class Main {
    // 벽 부수고 이동하기 - https://www.acmicpc.net/problem/2206

    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static class Node {
        int x;
        int y;
        int cnt;
        int wall;

        public Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!q.isEmpty()) {
            Node nNode = q.poll();
            if (nNode.x == N - 1 && nNode.y == M - 1) return nNode.cnt;

            for (int i = 0; i < 4; i++) {
                int nX = nNode.x + dx[i];
                int nY = nNode.y + dy[i];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (arr[nX][nY] == 0) {
                    if (!visited[nX][nY][nNode.wall]) {
                        q.add(new Node(nX, nY, nNode.cnt + 1, nNode.wall));
                        visited[nX][nY][nNode.wall] = true;
                    }
                } else if (arr[nX][nY] == 1) {
                    if (!visited[nX][nY][1] && nNode.wall == 0) {
                        q.add(new Node(nX, nY, nNode.cnt + 1, 1));
                        visited[nX][nY][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
