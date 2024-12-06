import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 쿼드트리 - https://www.acmicpc.net/problem/1992

    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        division(0, 0, N);
        System.out.println(sb);
    }

    public static void division(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(arr[row][col]);
            return;
        }
        sb.append('(');
        size /= 2;

        division(row, col, size);
        division(row, col + size, size);
        division(row + size, col, size);
        division(row + size, col + size, size);

        sb.append(')');
    }

    public static boolean check(int row, int col, int size) {
        int value = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(value != arr[i][j]) return false;
            }
        }
        return true;
    }
}
