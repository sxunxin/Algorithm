import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 창문 닫기 - https://www.acmicpc.net/problem/13909

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 1; i * i <= N; i++) { //제곱수만 카운트
            cnt++;
        }

        System.out.println(cnt);
    }
}
