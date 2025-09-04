import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 지뢰 찾기 - https://www.acmicpc.net/problem/1996

    public static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static int[][] map;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(arr[i][j])) {
                    int idx = Character.getNumericValue(arr[i][j]);

                    map[i][j] = -100;
                    AddMapNumber(idx, j, i);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < 0) sb.append("*");
                else if (map[i][j] > 9) sb.append("M");
                else sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void AddMapNumber(int idx, int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > -1 && nx < N && ny > -1 && ny < N) {
                map[ny][nx] += idx;
            }
        }
    }
}
