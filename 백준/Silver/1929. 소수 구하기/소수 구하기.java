import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 소수 구하기 - https://www.acmicpc.net/problem/1929
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] prime = sieveOfEratosthenes(M);
        for (int i = N; i <= M; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }
        return prime;
    }
}
