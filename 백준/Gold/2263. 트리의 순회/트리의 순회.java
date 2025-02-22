import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 트리의 순회 - https://www.acmicpc.net/problem/2263

    static int[] inorderArr;
    static int[] postorderArr;
    static int[] preorderArr;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        inorderArr = new int[N];
        postorderArr = new int[N];
        preorderArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorderArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorderArr[i] = Integer.parseInt(st.nextToken());
        }

        preOrder(0, N - 1, 0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.print(preorderArr[i] + " ");
        }
    }

    public static void preOrder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            preorderArr[idx++] = postorderArr[pe];
            int tmp = is;
            for (int i = is; i <= ie; i++) {
                if (inorderArr[i] == postorderArr[pe]) {
                    tmp = i;
                    break;
                }
            }
            preOrder(is, tmp - 1, ps, ps + tmp - is - 1);
            preOrder(tmp + 1, ie, ps + tmp - is, pe - 1);
        }
    }
}
