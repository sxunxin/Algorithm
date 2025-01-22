import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 베스킨라빈스 31 - https://www.acmicpc.net/problem/20004

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());

        for (int i = 1; i <= A; i++) {
            if (30 % (i + 1) == 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
