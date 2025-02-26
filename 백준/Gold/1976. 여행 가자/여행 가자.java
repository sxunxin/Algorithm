import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 여행 가자 - https://www.acmicpc.net/problem/1976

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            unf[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int road = Integer.parseInt(st.nextToken());
                if (road == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(start) != find(city)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) unf[b] = a;
            else unf[a] = b;
        }
    }

    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
