import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 다리 만들기 2 - https://www.acmicpc.net/problem/17472

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] parent;
    static ArrayList<Node> list;

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j, cnt);
                }
            }
        }

        parent = new int[cnt + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= cnt; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) findBridges(i, j);
            }
        }
        Collections.sort(list);

        int value = 0;
        int count = 0;
        for (Node n : list) {
            if (union(n.from, n.to)) {
                value += n.value;
                count++;

                if (count == cnt - 1) break;
            }
        }

//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        for (Node node : list) {
//            System.out.println(node.to + " -> " + node.from + " : " + node.value);
//        }

        if (value == 0 || count != cnt - 1)
            System.out.println(-1);
        else
            System.out.println(value);
    }

    static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        map[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny, cnt);
                }
            }
        }
    }

    static void findBridges(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int length = 0;
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == map[x][y]) break;
                if (map[nx][ny] >= 1) {
                    if (length >= 2) {
                        list.add(new Node(map[x][y], map[nx][ny], length));
                    }
                    break;
                }
                length++;
                nx += dx[i];
                ny += dy[i];
            }
        }
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        else parent[b] = a;
        return true;
    }

    static int find(int v) {
        if (v == parent[v]) return v;
        else return parent[v] = find(parent[v]);
    }
}
