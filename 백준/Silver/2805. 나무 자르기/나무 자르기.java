import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 나무 자르기 - https://www.acmicpc.net/problem/2805

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        while (min < max) {

            int mid = (max + min) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0)
                    sum += arr[i] - mid;
            }

            if (sum < M) max = mid;
            else min = mid + 1;
        }

        System.out.println(min - 1);
    }
}
