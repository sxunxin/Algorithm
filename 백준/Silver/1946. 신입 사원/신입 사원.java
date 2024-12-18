import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    // 신입 사원 - https://www.acmicpc.net/problem/1946

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1] = b;
            }
            int count = 1;
            int rating = arr[0];
            for (int j = 1; j < n; j++) {
                if (rating > arr[j]) {
                    count++;
                    rating = arr[j];
                }
            }
            System.out.println(count);
        }
    }
}
