import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 수 나누기 게임 - https://www.acmicpc.net/problem/27172

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] score = new int[1000001];
        boolean[] card = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[arr[i]] = true;
        }

        for (int i : arr) {
            for (int j = i * 2; j < 1000001; j += i) {
                if (card[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        for (int i : arr) {
            System.out.print(score[i] + " ");
        }

    }
}
