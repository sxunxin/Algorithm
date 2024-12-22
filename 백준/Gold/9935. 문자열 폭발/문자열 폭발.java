import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 문자열 폭팔 - https://www.acmicpc.net/problem/9935

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String word = br.readLine();
        int wordLen = word.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() < wordLen) continue;

            boolean isBoom = true;
            for (int j = 0; j < wordLen; j++) {
                if (stack.get(stack.size() - wordLen + j) != word.charAt(j)) {
                    isBoom = false;
                    break;
                }
            }
            if (isBoom) {
                for (int j = 0; j < wordLen; j++) {
                    stack.pop();
                }
            }
        }
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.isEmpty() ? "FRULA" : sb);
    }
}
