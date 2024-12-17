import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 다음 소수 - https://www.acmicpc.net/problem/4134

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        for (long i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            if (num <= 1)
                num = 2;
            while (!isPrime(num)) {
                num++;
            }
            System.out.println(num);
        }
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
