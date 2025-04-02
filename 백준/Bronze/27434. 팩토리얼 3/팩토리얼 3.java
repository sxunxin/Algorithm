import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    // 팩토리얼 3 - https://www.acmicpc.net/problem/27434

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("1");


        System.out.println(N == 0 ? 1 : factorial(1, N));
    }

    public static BigInteger factorial(int a, int b) {
        if (a == b) return BigInteger.valueOf(b);

        return factorial(a, (a + b) / 2).multiply(factorial((a + b) / 2 + 1, b));
    }
}
