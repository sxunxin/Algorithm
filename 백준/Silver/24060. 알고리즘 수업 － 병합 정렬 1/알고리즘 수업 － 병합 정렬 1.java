import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 알고리즘 수업 - 병합 정렬 1 - https://www.acmicpc.net/problem/24060

    public static int[] src;
    public static int[] tmp;
    public static int K;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        src = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, src.length-1);
        if (cnt < K)
            System.out.println(-1);
    }

    public static void mergeSort(int start, int end) {
        if (start<end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                    if (K == ++cnt)
                        System.out.println(tmp[idx-1]);
                } else {
                    tmp[idx++] = src[q++];
                    if (K == ++cnt)
                        System.out.println(tmp[idx-1]);
                }
            }
            for (int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }
}
