
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // !!초콜릿 중독 주의!! - https://www.acmicpc.net/problem/31458

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            int idx = 0;
            int num;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '!') {
                    idx = i;
                    break;
                }
            }

            if (str.length() == idx + 1) num = str.charAt(idx) - '0';
            else num = 1;

            if (idx % 2 == 1) num = (num == 1) ? 0 : 1;

            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
