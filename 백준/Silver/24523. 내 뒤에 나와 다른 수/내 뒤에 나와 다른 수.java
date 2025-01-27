import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 내 뒤에 나와 다른 수 - https://www.acmicpc.net/problem/24523

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 1;
        while (p1 <= p2) {
            if (p1 == N - 1) break;

            if (arr[p1] != arr[p2]) {
                for (int i = 0; i < (p2 - p1); i++) {
                    sb.append(p2 + 1).append(" ");
                }
                p1 = p2++;
            } else if (p2 == N - 1 && arr[p1] == arr[p2]) {
                for (int i = 0; i < (p2 - p1); i++) {
                    sb.append(-1).append(" ");
                }
                break;
            } else if (arr[p1] == arr[p2]) {
                p2++;
            }
        }
        sb.append(-1);
        System.out.println(sb);
    }
}
