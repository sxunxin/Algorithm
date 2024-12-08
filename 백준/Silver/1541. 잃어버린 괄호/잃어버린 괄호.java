import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 잃어버린 괄호 - https://www.acmicpc.net/problem/1541
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");

        int sum = -123456;
        while (st1.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }

            if (sum == -123456) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}

