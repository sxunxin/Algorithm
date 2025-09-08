import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // 농구 경기 - https://www.acmicpc.net/problem/1159

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char name = br.readLine().charAt(0);
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }

        for (char name : map.keySet()) {
            if (map.get(name) > 4) {
                sb.append(name);
            }
        }

        if (sb.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}
