import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 붙임성 좋은 총총이 - https://www.acmicpc.net/problem/26069

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals("ChongChong") ||
                    B.equals("ChongChong") ||
                    (map.containsKey(A) && map.get(A) == 1) ||
                    (map.containsKey(B) && map.get(B) == 1)) {

                if (!map.containsKey(A) || map.get(A) == 0)
                    cnt++;
                if (!map.containsKey(B) || map.get(B) == 0)
                    cnt++;
                map.put(A, 1);
                map.put(B, 1);
            } else {
                map.put(A, 0);
                map.put(B, 0);
            }
        }

        System.out.println(cnt);
    }
}
