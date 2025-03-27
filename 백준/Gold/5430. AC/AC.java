import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    // AC - https://www.acmicpc.net/problem/5430

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            executeCommand(command, deque);
        }
        System.out.println(sb);
    }

    public static void executeCommand(String command, ArrayDeque<Integer> deque) {
        boolean isFront = true;

        for (char c : command.toCharArray()) {
            if (c == 'R') {
                isFront = !isFront;
            } else {
                if (isFront) {
                    if (deque.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                } else {
                    if (deque.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        sb.append("[");
        if (!deque.isEmpty()) {
            if (isFront) {

                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {

                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}
