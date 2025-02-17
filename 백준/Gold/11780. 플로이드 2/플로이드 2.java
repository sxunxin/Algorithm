import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 플로이드 2 - https://www.acmicpc.net/problem/11780

    static final int INF = 100001;
    static int N, M;
    static int[][] arr;
    static List<Integer>[][] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        list = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                list[i][j] = new ArrayList<>();
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b], c);
        }

        Floyd();
        PrintAns();

        System.out.println(sb);
    }

    static void Floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        CheckVisited(i, j, k);
                    }
                }
            }
        }
    }

    static void CheckVisited(int i, int j, int k) {
        list[i][j].clear();
        for(int route : list[i][k]) {
            list[i][j].add(route);
        }
        list[i][j].add(k);
        for(int route : list[k][j]) {
            list[i][j].add(route);
        }
    }

    static void PrintAns() {
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == INF) {
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int size = list[i][j].size();
                if (i == j || arr[i][j] == INF) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append((size + 2)).append(" ").append(i).append(" ");
                for (int num : list[i][j]) {
                    sb.append(num).append(" ");
                }
                sb.append(j).append("\n");
            }
        }
    }
}
