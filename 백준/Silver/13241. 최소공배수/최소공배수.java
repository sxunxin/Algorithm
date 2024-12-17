import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 최소공배수 - https://www.acmicpc.net/problem/13241

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println((A * B) / gcd(A, B));
        
    }

    public static long gcd(long p, long q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }

}
