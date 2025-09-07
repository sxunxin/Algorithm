import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // IOIOI - https://www.acmicpc.net/problem/5525

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String text = br.readLine();
        String ioi = "I";

        for (int i = 0; i < N; i++) {
            ioi += "OI";
        }

        int cnt = 0;
        for (int i = 0; i < M - (N * 2); i++) {
            if (text.substring(i, i + (N * 2) + 1).equals(ioi)) cnt++;
        }

        System.out.println(cnt);
    }
}

