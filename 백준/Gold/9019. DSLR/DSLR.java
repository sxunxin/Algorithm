import java.io.*;
import java.util.*;

public class Main {
    // DSLR - https://www.acmicpc.net/problem/9019

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] rse = new String[10000];

            q.add(A);
            visited[A] = true;
            Arrays.fill(rse,  "");

            while (!q.isEmpty() && !visited[B]) {
                int now = q.poll();

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    rse[D] = rse[now] + "D";
                }
                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    rse[S] = rse[now] + "S";
                }
                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    rse[L] = rse[now] + "L";
                }
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    rse[R] = rse[now] + "R";
                }
            }
            System.out.println(rse[B]);
        }
    }
}
