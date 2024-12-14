import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 영단어 암기는 어려워 - https://www.acmicpc.net/problem/20920

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M)
                continue;
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else map.put(word, 0);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((entry1, entry2) -> {
            String word1 = entry1.getKey();
            String word2 = entry2.getKey();
            int freq1 = entry1.getValue();
            int freq2 = entry2.getValue();

            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            }

            if (word1.length() != word2.length()) {
                return Integer.compare(word2.length(), word1.length());
            }
            
            return word1.compareTo(word2);
        });

        for (Map.Entry<String, Integer> entry : list) {
           sb.append(entry.getKey()).append('\n');
        }

        System.out.println(sb);
    }
}
