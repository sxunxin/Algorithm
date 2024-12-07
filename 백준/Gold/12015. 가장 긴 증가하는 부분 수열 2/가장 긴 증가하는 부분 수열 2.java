import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 증가하는 부분 수열 2 - https://www.acmicpc.net/problem/12015

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int len = 1;

        for (int i = 0; i < N; i++) {
            int key = seq[i];

            if (LIS[len - 1] < key) {
                len++;
                LIS[len - 1] = key;
            } else {
                // 이분 탐색 (Lower Bound)
                int lo = 0;
                int hi = len;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (LIS[mid] < key) lo = mid + 1;
                    else hi = mid;
                }
                LIS[lo] = key;
            }
            // System.out.println(Arrays.toString(LIS));
        }
        System.out.println(len);
    }
}
