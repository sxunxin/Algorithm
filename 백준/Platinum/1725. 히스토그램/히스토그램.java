import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 히스토그램 - https://www.acmicpc.net/problem/1725

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 2];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        stack.push(0);
        int max = 0;

        for (int i = 1; i < N + 2; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (arr[top] <= arr[i]) break;
                stack.pop();
                max = Math.max(max, arr[top] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        System.out.println(max);
    }
}
