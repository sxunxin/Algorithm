import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 좌표압축 - https://www.acmicpc.net/problem/18870
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrSort = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arrSort);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < arrSort.length; i++) {
            rankMap.put(arrSort[i], i);
        }
        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(arr[i])).append(' ');
        }
        System.out.println(sb);
    }
}
