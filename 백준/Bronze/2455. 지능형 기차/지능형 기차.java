import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 지능형 기차 - https://www.acmicpc.net/problem/2455

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0, max = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            cnt -= Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if (cnt > max) max = cnt;
        }
        System.out.println(max);
    }
}
