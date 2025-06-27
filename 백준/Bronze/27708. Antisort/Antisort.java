import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Antisort - https://www.acmicpc.net/problem/27708

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        sb.append(T).append("\n\n");
        br.readLine();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (N > 2 && (arr[0] > arr[1] && arr[1] > arr[2] || arr[0] < arr[1] && arr[1] < arr[2])) {
                int tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
            sb.append(N).append("\n");
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n\n");
            if (T != 0) br.readLine();
        }

        System.out.println(sb);
    }
}
