import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 뱀과 사다리 게임 - https://www.acmicpc.net/problem/16928

    static int[] board = new int[101];
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < board.length; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            board[tmp] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = 0;

        while (true) {
            int nowNum = q.poll();

            for (int i = 1; i <= 6; i++) {
                int nextNum = nowNum + i;

                if (nextNum > 100) continue;
                if (visited[board[nextNum]] == 0) {
                    q.offer(board[nextNum]);
                    visited[board[nextNum]] = visited[nowNum] + 1;
                }
                if (board[nextNum] == 100) return visited[100];
            }
        }
    }
}
