import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 애너그램 - https://www.acmicpc.net/problem/6996

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            String first = st.nextToken();
            String second = st.nextToken();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }

    private static boolean solveAnagrams(String first, String second) {
        if (first.length() != second.length()) return false;

        int[] cntArr = new int[26];
        for (int i = 0; i < first.length(); i++) {
            cntArr[first.charAt(i) - 'a']++;
            cntArr[second.charAt(i) - 'a']--;
        }
        for (int c : cntArr) if (c != 0) return false;
        return true;
    }

}
