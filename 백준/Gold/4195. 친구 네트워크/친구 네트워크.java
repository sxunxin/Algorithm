import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 친구 네트워크 - https://www.acmicpc.net/problem/4195

    static int[] unf;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int idx = 0;

            unf = new int[N * 2];
            level = new int[N * 2];

            for (int i = 0; i < N * 2; i++) {
                unf[i] = i;
                level[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!map.containsKey(name1)) map.put(name1, idx++);
                if (!map.containsKey(name2)) map.put(name2, idx++);

                sb.append(union(map.get(name1), map.get(name2)) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            unf[b] = a;
            level[a] += level[b];
            level[b] = 1;
        }
        return level[a];
    }

    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
