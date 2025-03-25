import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 진법 변환 - https://www.acmicpc.net/problem/1112

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean isNegative = (b > 0 && x < 0);
        x = (b > 0) ? Math.abs(x) : x;

        String result = convertNum(x, b);
        if (isNegative) result = "-" + result;
        System.out.println(result);
    }

    public static String convertNum(int num, int b) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        int absB = Math.abs(b);

        while (num != 0) {
            int temp = num % absB;
            if (temp < 0) temp += absB;

            sb.append((char)('0' + temp));
            num = (num - temp) / b;
        }
        return sb.reverse().toString();
    }
}
