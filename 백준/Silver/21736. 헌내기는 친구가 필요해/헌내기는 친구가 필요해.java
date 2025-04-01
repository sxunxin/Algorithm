import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 헌내기는 친구가 필요해 - https://www.acmicpc.net/problem/21736

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 0, startY = 0;

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        System.out.println(cnt == 0 ? "TT" : cnt);
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node nNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = nNode.x + dx[i];
                int nY = nNode.y + dy[i];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M || visited[nX][nY] || map[nX][nY] == 'X') continue;

                if (map[nX][nY] == 'P') cnt++;

                queue.add(new Node(nX, nY));
                visited[nX][nY] = true;
            }
        }
    }
}
