import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 토마토 - https://www.acmicpc.net/problem/7576

    static int N, M, day;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<tomato> q = new LinkedList<>();

    static class tomato {
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) q.offer(new tomato(i, j, 0));
            }
        }

        bfs();


        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        day = 0;

        while (!q.isEmpty()) {
            tomato nTomato = q.poll();
            day = nTomato.day;

            for (int i = 0; i < 4; i++) {
                int nx = nTomato.x + dx[i];
                int ny = nTomato.y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.add(new tomato(nx, ny, day + 1));
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
