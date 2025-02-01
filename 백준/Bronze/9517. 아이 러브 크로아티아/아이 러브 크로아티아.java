import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 아이 러브 크로아티아 - https://www.acmicpc.net/problem/9517

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int time = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            String Z = st.nextToken();
            time += T;

            if (time > 210) break;
            if (Z.equals("T")) K++;
            if (K == 9) K = 1;
        }
        System.out.println(K);
    }
}
