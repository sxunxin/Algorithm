import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // IOIOI - https://www.acmicpc.net/problem/5525

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String text = br.readLine();
        StringBuilder pattern = new StringBuilder("I");

        for (int i = 0; i < N; i++) {
            pattern.append("OI");
        }

        int[] lpsArr = lps(pattern.toString());

        System.out.println(KMP(text, pattern.toString(), lpsArr));
    }

    public static int[] lps(String pattern) {
        int[] lpsArr = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lpsArr[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lpsArr[len - 1];
                } else {
                    lpsArr[i++] = 0;
                }
            }
        }
        return lpsArr;
    }

    private static int KMP(String text, String pattern, int[] lpsArr) {
        int i = 0, j = 0, cnt = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    cnt++;
                    j = lpsArr[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lpsArr[j - 1];
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }
}

