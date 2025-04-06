import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 별 찍기 - 19 - https://www.acmicpc.net/problem/10994

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N * 2; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(j % 2 == 1 ? "*" : " ");
                }
            } else {
                for (int j = 1; j <= N; j++) {
                    System.out.print(j % 2 == 1 ? " " : "*");
                }
            }
            System.out.println();
        }

    }
}
