import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 별 찍기 - 10 - https://www.acmicpc.net/problem/2447

    public static StringBuilder sb = new StringBuilder();
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], '*');
        }

        star(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void star(int x,int y, int len) {
        if (len == 1)
            return;
        int newLen = len / 3;

        for (int i = x + newLen; i < x + newLen * 2; i++) {
            for (int j = y + newLen; j < y + newLen * 2; j++) {
                arr[i][j] = ' ';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               if (i == 1 && j == 1)
                   continue;
               star(x + i * newLen, y + j * newLen, newLen);
            }
        }


    }
}
