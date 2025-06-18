import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 큐브 더미 - https://www.acmicpc.net/problem/27982

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][][] arr = new boolean[N + 2][N + 2][N + 2];
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]
                    [Integer.parseInt(st.nextToken())]
                    [Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 2; i < N; i++) {
            for (int j = 2; j < N; j++) {
                for (int k = 2; k < N; k++) {
                    if (arr[i][j][k] && arr[i + 1][j][k] && arr[i - 1][j][k] &&
                            arr[i][j + 1][k] && arr[i][j - 1][k] &&
                            arr[i][j][k + 1] && arr[i][j][k - 1]) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
