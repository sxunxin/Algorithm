import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 칸토어 집합 - https://www.acmicpc.net/problem/4779

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            int len = (int)Math.pow(3, Integer.parseInt(input));
            sb = new StringBuilder();

            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            cantorSet(0, len);
            System.out.println(sb);
        }
    }

    public static void cantorSet(int p, int len) {
        if (len == 1)
            return;

        int newLen = len / 3;
        for (int i = p+newLen; i < p+2*newLen; i++) {
            sb.setCharAt(i, ' ');
        }

        cantorSet(p, newLen);
        cantorSet(p+2*newLen, newLen);
    }
}
