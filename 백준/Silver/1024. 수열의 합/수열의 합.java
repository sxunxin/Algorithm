import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 수열의 합 - https://www.acmicpc.net/problem/1024

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        boolean flag = true;


        for (long i = L; i <= 100 && flag; i++) {
            long sum = (i * (i - 1)) / 2;
            long idx = 0;

            while (true) {
                if (sum == N) {
                    for (long k = 0; k < i; k++)
                        System.out.print(idx + k + " ");
                    flag = false;
                    break;
                }
                sum += i;
                idx += 1;
                if (sum > N) break;
            }
        }

        if (flag) System.out.print("-1");
    }
}
