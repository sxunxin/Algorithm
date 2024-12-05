import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 공유기 설치 - https://www.acmicpc.net/problem/2110

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[N - 1] - arr[0] + 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (countC(mid) < C) hi = mid;
            else lo = mid + 1;
        }

        System.out.println(lo - 1);
    }

    public static int countC(int distance) {
        int cnt = 1;
        int nowDistance = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int nextDistance = arr[i];

            if (nextDistance - nowDistance >= distance) {
                cnt++;
                nowDistance = nextDistance;
            }
        }
        return cnt;
    }
}
