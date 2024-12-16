import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 괄호 - https://www.acmicpc.net/problem/9012
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        char temp = '0';

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String PS = scanner.nextLine();

            for (int j = 0; j < PS.length(); j++) {
                if (!stack.isEmpty()) {
                    temp = stack.peek();
                }
                stack.push(PS.charAt(j));
                if (stack.size() > 1 && temp == '(' && PS.charAt(j) == ')') {
                    stack.pop();
                    stack.pop();
                }
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");

        }
    }
}
