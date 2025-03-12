import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    // 스도쿠 - https://www.acmicpc.net/problem/2239

    static int[][] map;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                map[i][j] = c[j] - '0';

                if (map[i][j] == 0)
                    list.add(new int[]{i, j});
            }
        }

        backTracking(0);
    }

    static void backTracking(int idx) {
        if (idx == list.size()) {
            printSudoku();
            System.exit(0);
        }

        int x = list.get(idx)[0];
        int y = list.get(idx)[1];

        boolean[] checked = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (map[x][i] != 0) checked[map[x][i]] = true;
            if (map[i][y] != 0) checked[map[i][y]] = true;
        }

        int blockX = (x / 3) * 3;
        int blockY = (y / 3) * 3;

        for (int i = blockX; i < blockX + 3; i++) {
            for (int j = blockY; j < blockY + 3; j++) {
                if (map[i][j] != 0) checked[map[i][j]] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!checked[i]) {
                map[x][y] = i;
                backTracking(idx + 1);
                map[x][y] = 0;
            }
        }
    }

    static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
