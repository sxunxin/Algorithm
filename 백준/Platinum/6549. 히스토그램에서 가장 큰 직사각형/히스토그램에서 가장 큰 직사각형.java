import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 히스토그램에서 가장 큰 직사각형 - https://www.acmicpc.net/problem/6549

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(division(0, N - 1)).append('\n');
            arr = null;
        }
        System.out.println(sb);
    }

    public static long division(int p1, int p2) {

        if (p1 == p2) return arr[p1];

        int mid = (p1 + p2) / 2;

        long leftArea = division(p1, mid);
        long rightArea = division(mid + 1, p2);
        
        return Math.max(Math.max(leftArea, rightArea), getMidArea(p1, p2, mid));
    }

    public static long getMidArea(int p1, int p2, int mid) {

        int toLeft = mid;
        int toRight = mid;
        long height = arr[mid];
        long maxArea = height;

        while (p1 < toLeft && toRight < p2) {
            if (arr[toLeft - 1] < arr[toRight + 1]) {
                toRight++;
                height = Math.min(height, arr[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, arr[toLeft]);
            }
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < p2) {
            toRight++;
            height = Math.min(height, arr[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        while (p1 < toLeft) {
            toLeft--;
            height = Math.min(height, arr[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
