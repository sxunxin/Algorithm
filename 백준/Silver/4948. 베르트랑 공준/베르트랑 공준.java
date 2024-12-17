import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 베르트랑 공준 - https://www.acmicpc.net/problem/4948

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int cnt = 0;
            for (int i = n+1; i <= n*2; i++) {
                cnt += isPrime(i);
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static int isPrime(long n) {
        for (long i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
