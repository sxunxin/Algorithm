import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 비밀번호 - https://www.acmicpc.net/problem/33702

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        switch (K) {
            case 1:
            case 3:
            case 7:
            case 9:
            case 5:
                System.out.println(8);
                break;
            default:
                System.out.println(0);
        }
    }
}
