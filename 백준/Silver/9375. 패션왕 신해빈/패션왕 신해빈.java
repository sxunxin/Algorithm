import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 패션왕 신해빈 - https://www.acmicpc.net/problem/9375

    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("0\n");
                continue;
            }

            map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String wear = st.nextToken();
                map.put(wear, map.getOrDefault(wear, 1) + 1);
            }

            int res = 1;
            for (Integer i : map.values()) {
                res *= i;
            }
            sb.append(--res).append("\n");
        }

        System.out.println(sb);
    }
}
