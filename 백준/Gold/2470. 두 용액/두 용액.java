import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 두 용액 - https://www.acmicpc.net/problem/2470

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] res = new int[2];
        int p1 = 0, p2 = N - 1;
        int minSum = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if (minSum > Math.abs(sum)) {
                minSum = Math.abs(sum);
                res[0] = arr[p1];
                res[1] = arr[p2];
            }

            if (sum < 0) p1++;
            else p2--;
        }

        System.out.println(res[0] + " " + res[1]);
    }
}
