import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 균형잡힌 세상 - https://www.acmicpc.net/problem/4949
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;

        while (true) {
            Stack<Character> st = new Stack<>();
            s = scanner.nextLine();

            if (s.equals(".")) break;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[') {
                    st.push(c);
                } else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        st.push(c);
                        break;
                    } else {
                        st.pop();
                    }
                } else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        st.push(c);
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if (st.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
