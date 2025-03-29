import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // 카드 - https://www.acmicpc.net/problem/11652

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(br.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int max = 0;
        long num = 0;
        for (long l : map.keySet()) {
            if (map.get(l) >= max) {
                if (map.get(l) == max) {
                    num = Math.min(l, num);
                } else {
                    max = map.get(l);
                    num = l;
                }
            }
        }
        System.out.println(num);
    }
}
