import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 팩토리얼 - https://www.acmicpc.net/problem/7489

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long res = 1;

            for (int i = 1; i <= N; i++) {
                res *= i;
                while (res % 10 == 0) res /= 10;
                res %= 1000000;
            }

            System.out.println(res % 10);
        }
    }
}
