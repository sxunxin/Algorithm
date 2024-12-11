import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 바이토닉 부분 수열 - https://www.acmicpc.net/problem/11054

    public static int[] arr;
    public static Integer[] dpLIS;
    public static Integer[] dpLDS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dpLIS = new Integer[N];
        dpLDS = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dpLIS[i] + dpLDS[i]);
        }
        System.out.println(max-1);
    }

    public static int LIS(int N) {
        if (dpLIS[N] == null) {
            dpLIS[N] = 1;

            for (int i = N-1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dpLIS[N] = Math.max(dpLIS[N], LIS(i) + 1);
                }
            }
        }

        return dpLIS[N];
    }

    public static int LDS(int N) {
        if (dpLDS[N] == null) {
            dpLDS[N] = 1;

            for (int i = N+1; i < dpLDS.length; i++) {
                if (arr[i] < arr[N]) {
                    dpLDS[N] = Math.max(dpLDS[N], LDS(i) + 1);
                }
            }
        }

        return dpLDS[N];
    }
}
