import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 가장 긴 증가하는 부분 수열 3 - https://www.acmicpc.net/problem/12738

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int nNum = arr[i];

            if (nNum > list.get(list.size() - 1)) {
                list.add(nNum);
            } else {
                int p1 = 1;
                int p2 = list.size() - 1;

                while (p1 < p2) {
                    int mid = (p1 + p2) / 2;
                    if (list.get(mid) >= nNum) p2 = mid;
                    else p1 = mid + 1;
                }
                list.set(p2, nNum);
            }
        }
        System.out.println(list.size() - 1);
    }
}
