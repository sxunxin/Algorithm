import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 냅색문제 - https://www.acmicpc.net/problem/1450

    static int N ,C;
    static int[] arr;
    static List<Integer> left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        left = new ArrayList<>();
        right = new ArrayList<>();
        sumArr(left, 0, N / 2, 0);
        sumArr(right, N / 2, N, 0);
        right.sort((a, b) -> (a - b));

        int cnt = 0, idx = 0;

        for (int i = 0; i < left.size(); i++) {
            idx = upperbound(0, right.size() - 1, left.get(i));
            cnt += idx + 1;
        }
        System.out.println(cnt);
    }

    public static void sumArr(List<Integer> list, int start, int end, int sum) {
        if (sum > C) return;
        if (start == end) {
            list.add(sum);
            return;
        }
        sumArr(list, start + 1, end, sum);
        sumArr(list, start + 1, end, sum + arr[start]);
    }

    public static int upperbound(int p1, int p2, int val) {
        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            if (right.get(mid) <= C - val) p1 = mid + 1;
            else p2 = mid - 1;
        }
        return p2;
    }
}
