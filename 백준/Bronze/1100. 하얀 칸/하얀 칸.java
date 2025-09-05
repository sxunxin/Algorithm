import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 하얀 칸 - https://www.acmicpc.net/problem/1100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();

            int j = i % 2;
            for (; j < 8; j += 2) {
                if (line.charAt(j) == 'F') cnt++;
            }
        }

        System.out.println(cnt);
    }
}
