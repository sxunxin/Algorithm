import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 색종이 만들기 - https://www.acmicpc.net/problem/2630

    public static int[][] arr;
    public static int W = 0;
    public static int B = 0;

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
        System.out.println(W);
        System.out.println(B);
    }

    public static void division(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == 0) W++;
            else B++;
            return;
        }

        size /= 2;
        division(row, col, size);
        division(row, col + size, size);
        division(row + size, col, size);
        division(row + size, col + size, size);
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
