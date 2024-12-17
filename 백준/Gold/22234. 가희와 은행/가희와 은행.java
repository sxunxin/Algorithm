import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 가희와 은행 - https://www.acmicpc.net/problem/22234

    public static void main(String[] args) throws IOException {
        // 초기 입력 & 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int time = 0;

        Queue<int[]> line = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            line.add(arr);
        }

        int M = Integer.parseInt(br.readLine());

        HashMap<Integer, int[]> nextLine = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int key = Integer.parseInt(st.nextToken());
            nextLine.put(key, arr);
        }

        // 시뮬레이션 파트
        loop:
        while (true) {
            if (!line.isEmpty() && line.peek()[1] <= T) {
                for (int i = 0; i < line.peek()[1]; i++) {
                    time += 1;
                    sb.append(line.peek()[0]).append("\n");
                    if (time == W)
                        break loop;

                    // 추가 있으면 넣기
                    if (nextLine.containsKey(time)) {
                        line.add(nextLine.get(time));
                    }
                }
                line.remove();
            } else {
                for (int i = 0; i < T; i++) {
                    time += 1;
                    line.peek()[1]--;
                    sb.append(line.peek()[0]).append("\n");
                    if (time == W)
                        break loop;

                    // 추가 있으면 넣기
                    if (nextLine.containsKey(time)) {
                        line.add(nextLine.get(time));
                    }
                }
                line.add(line.remove());
            }
        }

        System.out.println(sb);
    }
}
