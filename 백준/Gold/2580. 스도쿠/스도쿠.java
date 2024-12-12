import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 스도쿠 - https://www.acmicpc.net/problem/2580

    public static StringBuilder sb = new StringBuilder();
    public static int[][] arr = new int[9][9];
    public static boolean[][] row = new boolean[9][10];
    public static boolean[][] col = new boolean[9][10];
    public static boolean[][] Square = new boolean[9][10];

    public static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] != 0) {
                    row[i][arr[i][j]] = true;
                    col[j][arr[i][j]] = true;
                    Square[square(i,j)][arr[i][j]] = true;
                }
            }
        }

        DFS(0);
    }

    public static void DFS(int n) {
        if (n==81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        int x = n/9;
        int y = n%9;
        if (arr[x][y] == 0){
            for (int i = 1; i < 10; i++) {
                if (!row[x][i] && !col[y][i] && !Square[square(x, y)][i]) {
                    row[x][i] = col[y][i] = Square[square(x, y)][i] = true;
                    arr[x][y] = i;
                    DFS(n + 1);
                    arr[x][y] = 0;
                    row[x][i] = col[y][i] = Square[square(x, y)][i] = false;
                }
            }
        }
        else DFS(n+1);
    }
}
