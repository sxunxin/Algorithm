import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    // 이중 우선순위 큐 - https://www.acmicpc.net/problem/7662

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int option = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    treeMap.put(option, treeMap.getOrDefault(option, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) continue;

                    int num;
                    if (option == 1) {
                        num = treeMap.lastKey();
                    } else {
                        num = treeMap.firstKey();
                    }

                    int numCnt = treeMap.get(num);
                    if (numCnt == 1) {
                        treeMap.remove(num);
                    } else {
                        treeMap.put(num, numCnt - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
