import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // 덱 2 - https://www.acmicpc.net/problem/28279

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            if (c == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (c == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (c == 3) {
                sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
            } else if (c == 4) {
                sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
            } else if (c == 5) {
                sb.append(deque.size()).append("\n");
            } else if (c == 6) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (c == 7) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if (c == 8) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
