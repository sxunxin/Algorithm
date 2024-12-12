import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 스타트와 링크 - https://www.acmicpc.net/problem/14889

    public static int[][] arr;
    public static int N;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0);

        System.out.println(min);
    }

    public static void div(int idx, int cnt) {
        if (cnt == N / 2) {
            diff();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                div(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int team1 = 0;
        int team2 = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    team1 += arr[i][j];
                    team1 += arr[j][i];
                }
                else if (!visit[i] && !visit[j]) {
                    team2 += arr[i][j];
                    team2 += arr[j][i];
                }
            }
        }

        int num = Math.abs(team1 - team2);

        if (num == 0) {
            System.out.println(num);
            System.exit(0);
        }

        min = Math.min(num, min);
    }
}
