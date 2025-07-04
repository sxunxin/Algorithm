

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 비교 연산자 - https://www.acmicpc.net/problem/5656

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 0;
        while (true) {
            T++;
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            String symbol = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());

            if (symbol.equals("E")) {
                break;
            }

            System.out.print("Case " + T + ": ");
            if (symbol.equals(">")) System.out.println(num1 > num2 ? "true" : "false");
            else if (symbol.equals(">=")) System.out.println(num1 >= num2 ? "true" : "false");
            else if (symbol.equals("<")) System.out.println(num1 < num2 ? "true" : "false");
            else if (symbol.equals("<=")) System.out.println(num1 <= num2 ? "true" : "false");
            else if (symbol.equals("==")) System.out.println(num1 == num2 ? "true" : "false");
            else System.out.println(num1 != num2 ? "true" : "false");

        }
    }
}
