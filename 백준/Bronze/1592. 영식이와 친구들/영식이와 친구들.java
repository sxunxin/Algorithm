import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 영식이와 친구들 - https://www.acmicpc.net/problem/1592

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int cnt = -1;
        int idx = 0;
        int[] arr = new int[N];

        while (true) {
            arr[idx] += 1;
            cnt++;
            if (arr[idx] == M) break;

            if (arr[idx] / 2 == 1) {
                idx += L;
                if (idx >= N) idx -= N;
            } else {
                idx -= L;
                if (idx < 0) idx += N;
            }
        }

        System.out.println(cnt);
    }
}
