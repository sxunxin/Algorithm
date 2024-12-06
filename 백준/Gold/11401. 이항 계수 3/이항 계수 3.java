

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 이항 계수 3 - https://www.acmicpc.net/problem/11401

    public static final long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        System.out.println((factorial(N) * pow((factorial(N - K) * factorial(K)) % P, P - 2)) % P);
    }

    public static long factorial(long N) {
        if (N <= 1) {
            return 1;
        }
        return (N * factorial(N - 1)) % P;
    }

    public static long pow(long A, long B) {
        if (B == 1) return  A % P;

        long tmp = pow(A, B / 2);

        if (B % 2 == 1) return (tmp * tmp % P) * A % P;
        else return tmp * tmp % P;
    }
}
