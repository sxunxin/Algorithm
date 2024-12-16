import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 스택 2 - https://www.acmicpc.net/problem/28278

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                if (stack.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(stack.pop()).append('\n');
            } else if (command == 3) {
                sb.append(stack.size()).append('\n');
            } else if (command == 4) {
                if (stack.isEmpty())
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            } else if (command == 5) {
                if (stack.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(stack.peek()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
