import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 마인크래프트 - https://www.acmicpc.net/problem/18111

    public static int N, M, B;
    public static int maxHeight, minHeight;
    public static int time = 0;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        maxHeight = Integer.MIN_VALUE;
        minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > maxHeight) maxHeight = map[i][j];
                if (map[i][j] < minHeight) minHeight = map[i][j];
            }
        }

        while (true) {
            if (minHeight == maxHeight) break;

            if (checkCommand(minHeight + 1)) {
                setBlock();
            } else {
                removeBlock();
            }
        }

        System.out.println(time + " " + minHeight);

    }

    public static boolean checkCommand(int targetHeight) {
        int setTime = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < targetHeight) setTime++;
            }
        }

        int removeTime = (N * M - setTime) * 2;
        if (setTime <= B && setTime <= removeTime) return true;
        return false;
    }

    public static void setBlock() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == minHeight) {
                    map[i][j]++;
                    time++;
                    B--;
                }
            }
        }
        minHeight++;
    }

    public static void removeBlock() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == maxHeight) {
                    map[i][j]--;
                    time += 2;
                    B++;
                }
            }
        }
        maxHeight--;
    }
}
