import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 괄호의 값 - https://www.acmicpc.net/problem/2504

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;

        String N = br.readLine();

        for(int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '(') {
                stack.push(N.charAt(i));
                tmp *= 2;
            } else if(N.charAt(i) == '[') {
                stack.push(N.charAt(i));
                tmp *= 3;
            } else if(N.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(N.charAt(i-1) == '(') {
                    result += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if(N.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (N.charAt(i - 1) == '[') {
                    result += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }


        if (!stack.isEmpty())
            sb.append(0).append("\n");
        else
            sb.append(result).append("\n");

        System.out.println(sb);
    }

}
