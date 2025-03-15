import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 세 용액 - https://www.acmicpc.net/problem/2473

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int ans1 = 0, ans2 = 0, ans3 = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int p1 = i + 1, p2 = N - 1;

            while (p1 < p2) {
                long sum = arr[p1] + arr[p2] + arr[i];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ans1 = i;
                    ans2 = p1;
                    ans3 = p2;
                }
                if (sum >= 0) p2--;
                else p1++;
            }
        }
        System.out.println(arr[ans1] + " " +arr[ans2] + " " + arr[ans3]);
    }
}
