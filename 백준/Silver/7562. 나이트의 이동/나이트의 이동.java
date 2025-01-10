import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    // 나이트의 이동 - https://www.acmicpc.net/problem/7562

    static int N;
    static int[][] board;
    static int[] startPos = new int[2];
    static int[] endPos = new int[2];

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (0 < T--) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            st = new StringTokenizer(br.readLine());
            startPos[0] = Integer.parseInt(st.nextToken());
            startPos[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endPos[0] = Integer.parseInt(st.nextToken());
            endPos[1] = Integer.parseInt(st.nextToken());

            bfs(startPos[0], startPos[1]);

            System.out.println(board[endPos[0]][endPos[1]] - 1);
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        board[startX][startY] = 1;

        while (!q.isEmpty()) {
            Point nPoint = q.poll();

            for (int i = 0; i < 8; i++) {
                int nX = nPoint.x + dx[i];
                int nY = nPoint.y + dy[i];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                if (board[nX][nY] != 0) continue;

                q.offer(new Point(nX, nY));
                board[nX][nY] = board[nPoint.x][nPoint.y] + 1;
            }
        }
    }
}
