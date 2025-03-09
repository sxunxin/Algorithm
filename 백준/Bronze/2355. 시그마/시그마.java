import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 시그마 - https://www.acmicpc.net/problem/2355

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long minNum = Math.min(A, B);
        long maxNum = Math.max(A, B);
        long sum = (((maxNum + 1) * maxNum) / 2) - (((minNum - 1) * minNum) / 2);
        System.out.println(sum);
    }
}
