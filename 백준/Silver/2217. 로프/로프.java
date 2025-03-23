import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    // 로프 - https://www.acmicpc.net/problem/2217

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for (int i = 1; i <= N; i++) {
            int tmp = i * arr[i-1];
            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);
    }
}
