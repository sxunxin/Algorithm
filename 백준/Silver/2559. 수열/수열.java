import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 수열 - https://www.acmicpc.net/problem/2559

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int frontV = 0;
        int backV = K;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < K) sum += arr[i];
        }
        int max = sum;

        for (; backV < N; backV++) {
            sum += arr[backV];
            sum -= arr[frontV++];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
