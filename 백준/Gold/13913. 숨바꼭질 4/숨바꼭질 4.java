import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 숨바꼭질 4 - https://www.acmicpc.net/problem/13913

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] indexArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];
        indexArr = new int[100001];

        bfs(N);
        System.out.println(arr[M]);

        Stack<Integer> stack = new Stack<>();
        stack.add(M);
        int index = M;
        while (index != N) {
            stack.add(indexArr[index]);
            index = indexArr[index];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int p = q.poll();

            if (p == M) return;

            if ((p * 2 <= 100000) && !visited[p * 2]) {
                q.offer(p * 2);
                visited[p * 2] = true;
                indexArr[p * 2] = p;
                arr[p * 2] = arr[p] + 1;
            }

            if ((p - 1 >= 0) && !visited[p - 1]) {
                q.offer(p - 1);
                visited[p - 1] = true;
                indexArr[p - 1] = p;
                arr[p - 1] = arr[p] + 1;
            }

            if ((p + 1 <= 100000) && !visited[p + 1]) {
                q.offer(p + 1);
                visited[p + 1] = true;
                indexArr[p + 1] = p;
                arr[p + 1] = arr[p] + 1;
            }

        }
    }
}
