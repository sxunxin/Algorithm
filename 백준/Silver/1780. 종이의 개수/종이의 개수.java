import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 종이의 개수 - https://www.acmicpc.net/problem/1780

    public static int[][] arr;
    public static int R = 0; // -1
    public static int G = 0; // 0
    public static int B = 0; // 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(0, 0, N);
        System.out.println(R);
        System.out.println(G);
        System.out.println(B);
    }

    public static void division(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == -1) R++;
            else if (arr[row][col] == 0) G++;
            else B++;
            return;
        }

        size /= 3;
        division(row, col, size);
        division(row + size, col, size);
        division(row + size * 2, col, size);

        division(row, col + size, size);
        division(row + size, col + size, size);
        division(row + size * 2, col + size, size);

        division(row, col + size * 2, size);
        division(row + size, col + size * 2, size);
        division(row + size * 2, col + size * 2, size);
    }

    public static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col ; j < col + size; j++) {
                if (arr[i][j] != color) return false;
            }
        }
        return true;
    }
}
