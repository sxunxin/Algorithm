import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    // 나는야 포켓몬 마스터 이다솜 - https://www.acmicpc.net/problem/1620
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map1.put(str, i);
            map2.put(i, str);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
                sb.append(map2.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(map1.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
