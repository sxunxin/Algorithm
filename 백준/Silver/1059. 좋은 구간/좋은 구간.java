import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 좋은 구간 - https://www.acmicpc.net/problem/1059

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[L] = 0;
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());

        int start = arr[0];
        int end = arr[0];
        int cnt = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == n || arr[i + 1] == n) {
                cnt = 0;
                break;
            } else if (arr[i] < n && n < arr[i + 1]) {
                cnt = (n - arr[i]) * (arr[i + 1] - n) - 1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
