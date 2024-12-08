import java.io.*;
import java.util.*;

public class Main {
    // 체스판 다시 칠하기 2 - https://www.acmicpc.net/problem/25682

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        boolean color = false;
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = str.charAt(j - 1);
                if (!color && c == 'W') arr[i][j] = 1;
                else if (color && c == 'B') arr[i][j] = 1;
                color = !color;
            }
            if (M % 2 == 0) color = !color;
        }

        for (int i = 1; i <= N; i++) {
            int tmp = arr[i][1];
            for (int j = 2; j <= M; j++) {
                tmp += arr[i][j];
                arr[i][j] = tmp;
            }
        }
        for (int i = 1; i <= M; i++) {
            int tmp = arr[1][i];
            for (int j = 2; j <= N; j++) {
                tmp += arr[j][i];
                arr[j][i] = tmp;
            }
        }

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int tmp = arr[i][j] - (arr[i - K][j] + arr[i][j - K] - arr[i - K][j - K]);
                min = Math.min(min, tmp);
                max = Math.max(max, tmp);
            }
        }

        System.out.println(Math.min(min, K * K - max));
    }
}
