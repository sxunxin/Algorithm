import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Z - https://www.acmicpc.net/problem/1074

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        findPoint(r, c, (int) Math.pow(2, N));

        System.out.println(cnt);
    }

    public static void findPoint(int r, int c, int size) {

        if (size == 1) return;

        size /= 2;

        if (r < size && c < size) {
            findPoint(r, c, size);
        } else if (r < size) {
            cnt += size * size;
            findPoint(r, c - size, size);
        } else if (c < size) {
            cnt += size * size * 2;
            findPoint(r - size, c, size);
        } else {
            cnt += size * size * 3;
            findPoint(r - size, c - size, size);
        }
    }
}


