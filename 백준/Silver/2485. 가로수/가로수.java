import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 가로수 - https://www.acmicpc.net/problem/2485

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tmp = 0;
        for (int i = 0; i < N-1; i++) {
            int d = arr[i+1] - arr[i];
            tmp = gcd(d, tmp);
        }

        System.out.println((arr[N-1] - arr[0]) / tmp + 1 - arr.length);

    }

    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
