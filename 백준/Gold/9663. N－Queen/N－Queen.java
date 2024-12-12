import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // N-Queen - https://www.acmicpc.net/problem/9663

    public static int cnt = 0;
    public static int[] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        func(0);

        System.out.println(cnt);
    }

    public static void func(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (able(depth))
                func(depth+1);
        }
    }

    public static boolean able(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i])
                return false;
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;
    }
}
