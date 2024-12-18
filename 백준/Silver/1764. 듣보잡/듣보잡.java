import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 듣보잡 - https://www.acmicpc.net/problem/1764
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> map1 = new HashSet<>();
        HashSet<String> map2 = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            map1.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            map2.add(br.readLine());
        }

        map1.retainAll(map2);
        String[] arr = map1.toArray(new String[0]);
        Arrays.sort(arr);
        sb.append(arr.length).append("\n");

        for (String i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
