import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 팩토리얼5 - https://www.acmicpc.net/problem/1564

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N + 1];
        long num;

        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] * i;

            while (arr[i] % 10 == 0) arr[i] /= 10;
            arr[i] %= 1000000000000L;
        }
        num = arr[N] % 100000;
        System.out.printf("%05d", num);

    }
}
