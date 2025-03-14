import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 용액 - https://www.acmicpc.net/problem/2467

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int p1 = 0, p2 = N - 1;
        int ans1 = 0, ans2 = 0;
        long min = Integer.MAX_VALUE;

        while (p1 < p2) {
            long sum = arr[p1] + arr[p2];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ans1 = p1;
                ans2 = p2;
            }
            if (sum >= 0) p2--;
            else p1++;
        }

        System.out.println(arr[ans1] + " " + arr[ans2]);
    }
}
