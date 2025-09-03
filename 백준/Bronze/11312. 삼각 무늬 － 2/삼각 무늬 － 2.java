import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 삼각 무늬 - 2 - https://www.acmicpc.net/problem/11312

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            Long A = Long.parseLong(st.nextToken());
            Long B = Long.parseLong(st.nextToken());

            System.out.println((A * A) / (B * B));
        }
    }
}
