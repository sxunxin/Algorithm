import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 암호 - https://www.acmicpc.net/problem/1855

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String code = br.readLine();

        int M = code.length() / N;
        String[] code_arr = code.split("");


        String[][] arr = new String[M][N];

        int tmp = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 == 1) {
                    arr[i][N - j - 1] = code_arr[tmp++];
                } else {
                    arr[i][j] = code_arr[tmp++];
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb);
    }
}
