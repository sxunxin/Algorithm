import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 책 페이지 - https://www.acmicpc.net/problem/1019

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] res = new int[10];
        int digit = 1;

        while (N > 0) {

            while (N % 10 != 9 && N > 0) {
                for (char ch : String.valueOf(N).toCharArray()) {
                    if (Character.isDigit(ch)) {
                        res[ch - '0'] += digit;
                    }
                }
                N--;
            }

            if (N < 10) {
                for (int i = 0; i <= N; i++) {
                    res[i] += digit;
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    res[i] += (N / 10 + 1) * digit;
                }
            }

            res[0] -= digit;
            digit *= 10;
            N /= 10;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}
