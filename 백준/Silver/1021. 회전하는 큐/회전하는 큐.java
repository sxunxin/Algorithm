import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 회전하는 큐 - https://www.acmicpc.net/problem/1021

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int[] arr = new int[M];
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int target = q.indexOf(arr[i]);
            int half = q.size() / 2;

            if (q.size() % 2 == 0) half--;

            if (target <= half) {
                for (int j = 0; j < target; j++) {
                    int tmp = q.pollFirst();
                    q.offerLast(tmp);
                    cnt++;
                }
            } else {
                for (int j = 0; j < q.size() - target; j++) {
                    int tmp = q.pollLast();
                    q.offerFirst(tmp);
                    cnt++;
                }
            }
            q.pollFirst();
        }
        System.out.println(cnt);
    }
}
