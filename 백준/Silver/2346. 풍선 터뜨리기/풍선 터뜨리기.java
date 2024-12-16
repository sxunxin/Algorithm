import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // 풍선 터뜨리기 - https://www.acmicpc.net/problem/2346

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            deque.addLast(new int[] {i + 1, Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < N; i++) {
            int[] balloon = deque.removeFirst();
            int index = balloon[0];
            int move = balloon[1];

            sb.append(index).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            if (move > 0) {
                for (int j = 1; j < move; j++)
                    deque.addLast(deque.removeFirst());
            } else {
                for (int j = 0; j < -move; j++)
                    deque.addFirst(deque.removeLast());
            }
        }

        System.out.println(sb);
    }
}
