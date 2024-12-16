import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 도키도 간식드리미 - https://www.acmicpc.net/problem/12789

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int count = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int lineNumber = Integer.parseInt(st.nextToken());
            if (lineNumber == count) {
                count++;
            } else {
                stack.push(lineNumber);
            }

            while (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            }
        }

        System.out.println(count == N+1 ? "Nice" : "Sad");
    }
}
