import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 마지막 팩토리얼 수 - https://www.acmicpc.net/problem/2553

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
