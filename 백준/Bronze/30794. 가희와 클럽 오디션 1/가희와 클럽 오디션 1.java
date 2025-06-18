import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가희와 클럽 오디션 1 - https://www.acmicpc.net/problem/30794

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lv = Integer.parseInt(st.nextToken());
        String rank = st.nextToken();

        switch (rank) {
            case "bad":
                System.out.println(200 * lv);
                break;
            case "cool":
                System.out.println(400 * lv);
                break;
            case "great":
                System.out.println(600 * lv);
                break;
            case "perfect":
                System.out.println(1000 * lv);
                break;
            default:
                System.out.println(0);
        }

    }
}
