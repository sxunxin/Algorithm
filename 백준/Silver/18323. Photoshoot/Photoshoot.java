import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Photoshoot - https://www.acmicpc.net/problem/18323

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 1;
        while (true) {
            boolean isClear = true;
            boolean[] visited = new boolean[N + 1];
            arrA[0] = tmp;
            visited[tmp] = true;

            for (int i = 0; i < N - 1; i++) {
                arrA[i + 1] = arrB[i] - arrA[i];
                if (arrA[i + 1] < 1 || arrA[i + 1] > N || visited[arrA[i + 1]]) {
                    isClear = false;
                    break;
                }
                visited[arrA[i + 1]] = true;
            }
            if (isClear) break;
            tmp++;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arrA[i] + " ");
        }
    }
}
