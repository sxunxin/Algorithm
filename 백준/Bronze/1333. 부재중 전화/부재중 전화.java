import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 부재중 전화 - https://www.acmicpc.net/problem/1333

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] callAbleTime = new boolean[N * L + 5 * (N - 1)];

        for (int i = 0; i < N; i++) {
            int tmp = (L + 5) * i;

            for (int j = tmp; j < tmp + L; j++) {
                callAbleTime[j] = true;
            }
        }

        int callTime = 0;
        while (callTime < callAbleTime.length) {
            if (!callAbleTime[callTime]) {
                break;
            }
            callTime += D;
        }

        System.out.println(callTime);
    }
}
