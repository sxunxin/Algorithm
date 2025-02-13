import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 경찰차 - https://www.acmicpc.net/problem/2618

    static int N, W;
    static int[][] point;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        point = new int[W + 1][2];
        dp = new int[1001][1001];

        for (int i = 1; i <= W; i++) {
           st = new StringTokenizer(br.readLine());
           point[i][0] = Integer.parseInt(st.nextToken());
           point[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(1, 0, 0));

        int car1 = 0;
        int car2 = 0;
        for (int i = 1; i <= W; i++) {
            int dis = getDistance(1, car1, i);

            if (dp[car1][car2] - dis == dp[i][car2]) {
                car1 = i;
                sb.append(1).append("\n");
            } else {
                car2 = i;
                sb.append(2).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int dfs(int nPoint, int car1, int car2) {
        if (nPoint > W) return 0;

        if (dp[car1][car2] != 0) return dp[car1][car2];

        int disCar1 = dfs(nPoint + 1, nPoint, car2) + getDistance(1, car1, nPoint);
        int disCar2 = dfs(nPoint + 1, car1, nPoint) + getDistance(2, car2, nPoint);

        return dp[car1][car2] = Math.min(disCar1, disCar2);
    }

    public static int getDistance(int type, int start, int end) {
        int[] startArr = point[start];
        int[] endArr = point[end];

        if (start == 0) {
            if (type == 1) startArr = new int[]{1, 1};
            else startArr = new int[]{N, N};
        }
        return Math.abs(startArr[0] - endArr[0]) + Math.abs(startArr[1] - endArr[1]);
    }
}
