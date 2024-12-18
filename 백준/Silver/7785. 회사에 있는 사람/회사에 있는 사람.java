import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 회사에 있는 사람 - https://www.acmicpc.net/problem/7785

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String bool = st.nextToken();

            if (bool.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        for (String value : list) {
            System.out.println(value);
        }

    }
}
