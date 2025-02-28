import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 사이클 게임 - https://www.acmicpc.net/problem/20040

    static int[] unf;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N];
        res = 0;
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b, i);

            if (res != 0) break;
        }
        System.out.println(res);
    }

    public static void union(int a, int b, int time) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) unf[b] = a;
            else unf[a] = b;
        } else {
            res = ++time;
        }
    }

    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
}
