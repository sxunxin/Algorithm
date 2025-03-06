import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 초성 변환 - https://www.acmicpc.net/problem/12090

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (char c : input.toCharArray()) {
            if (c >= '가' && c <= '힣') {
                int unicode = c - 0xAC00;
                int initialIdx = unicode / (21 * 28);
                char initial = getInitial(initialIdx);
                sb.append(initial);
            }
        }
        System.out.println(sb);
    }

     static char getInitial(int index) {
        char[] initials = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
        return initials[index];
    }
}
