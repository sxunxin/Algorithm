import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 곱셈 - https://www.acmicpc.net/problem/1629

    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    public static long pow(long A, long B) {
        if (B == 1) return  A % C;

        long tmp = pow(A, B / 2);

        if (B % 2 == 1) return (tmp * tmp % C) * A % C;
        else return tmp * tmp % C;
    }

}
