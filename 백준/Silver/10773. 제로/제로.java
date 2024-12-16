import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 제로 - https://www.acmicpc.net/problem/10773
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (num == 0) st.pop();
            else st.push(num);
        }
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        System.out.println(sum);
    }
}
