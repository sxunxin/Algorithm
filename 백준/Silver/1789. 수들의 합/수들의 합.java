import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 수들의 합 - https://www.acmicpc.net/problem/1789

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int N = 1;
        while (true) {
            if (S >= N) S -= N;
            else break;
            N++;
        }
        System.out.println(--N);
    }
}
