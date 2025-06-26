
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // Black and White - https://www.acmicpc.net/problem/18156

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean isCorrect = true;
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            int cntW = 0;
            int cntB = 0;
            char color1 = 'A';
            char color2 = 'A';

            for (int j = 0; j < N; j++) {

                if (color1 == color2 && arr[i][j] == color2) {
                    System.out.println(0);
                    return;
                }

                if (arr[i][j] == 'W') cntW++;
                else cntB++;

                color2 = color1;
                color1 = arr[i][j];
            }

            if (cntW != cntB) {
                System.out.println(0);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int cntW = 0;
            int cntB = 0;
            char color1 = 'A';
            char color2 = 'A';

            for (int j = 0; j < N; j++) {

                if (color1 == color2 && arr[j][i] == color2) {
                    System.out.println(0);
                    return;
                }

                if (arr[j][i] == 'W') cntW++;
                else cntB++;

                color2 = color1;
                color1 = arr[j][i];
            }

            if (cntW != cntB) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);

    }
}
