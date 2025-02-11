import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 증가하는 부분 수열 4 - https://www.acmicpc.net/problem/14002

    static int N;
    static int[] arr;
    static int[] dp;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        tmp = new int[N + 1];

        int res = 0;
        int resIdx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    tmp[i] = j;
                }
            }
            if (dp[i] > res) {
                res = dp[i];
                resIdx = i;
            }
        }

        System.out.println(res);
        int[] ansArr = new int[res];
        for (int i = 0; i < res; i++) {
            ansArr[i] = arr[resIdx];
            resIdx = tmp[resIdx];
        }

        for (int i = res - 1; i >= 0; i--) {
            System.out.print(ansArr[i] + " ");
        }

    }
}
