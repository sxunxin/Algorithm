import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 나머지 합 - https://www.acmicpc.net/problem/10986

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long res = 0;
        long[] S = new long[N + 1];
        long[] cnt = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (S[i] == 0) {
                res++;
            }
            cnt[(int) S[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                res += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        System.out.println(res);
    }
}
