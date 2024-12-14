import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 인사성 밝은 곰곰이 - https://www.acmicpc.net/problem/25192

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int newEnter = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                newEnter++;

            } else if (!map.containsKey(input) ||map.get(input) != newEnter) {
                map.put(input, newEnter);
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}
