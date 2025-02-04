import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 부분합 - https://www.acmicpc.net/problem/1806

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0, sum = 0;
        int len = Integer.MAX_VALUE;

        while (p1 <= p2 && p2 <= N) {
            if (sum < S) {
                sum += arr[p2++];
            } else {
                len = Math.min(len, p2 - p1);
                sum -= arr[p1++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);

    }
}
