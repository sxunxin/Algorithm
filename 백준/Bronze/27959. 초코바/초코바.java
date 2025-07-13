import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 초코바 - https://www.acmicpc.net/problem/27959

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) * 100;
        int M = Integer.parseInt(st.nextToken());

        System.out.println(N >= M ? "Yes" : "No");

    }
}
