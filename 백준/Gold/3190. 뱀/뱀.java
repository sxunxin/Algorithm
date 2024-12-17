import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 뱀 - https://www.acmicpc.net/problem/3190

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // =============== 맵 제작 ===============
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];

        // 맵의 경계 제작 : 2일 경우 벽 -> 게임 오버
        for (int i = 0; i < N+2; i++) {
            map[0][i] = 2;
            map[N+1][i] = 2;
            map[i][0] = 2;
            map[i][N+1] = 2;
        }

        // 사과 위치 설정
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        // =============== 턴 해쉬맵 제작 ===============
        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> turn = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            turn.put(second, direction);
        }

        // =============== 뱀 제작 및 이동 ===============
        Queue<String> snake = new LinkedList<>();
        snake.add("1,1");
        int second = 0;
        // direction -> 1 : 좌 , 2 : 하 , 3 : 우 , 4 : 상
        int direction = 2;
        int nX = 1;
        int nY = 1;

        // 움직이기
        while (true) {
            // 방향 정하기
            if (turn.containsKey(second)) {
                char d = turn.get(second);
                if (d == 'D') direction++;
                if (d == 'L') direction--;
            }
            if (direction == -1) direction = 3;
            if (direction == 4) direction = 0;

            int x = 0;
            int y = 0;
            if (direction == 1) {
                x = nX - 1;
                y = nY;
            } else if (direction == 2) {
                x = nX;
                y = nY + 1;
            } else if (direction == 3) {
                x = nX + 1;
                y = nY;
            } else if (direction == 0) {
                x = nX;
                y = nY - 1;
            }

            second++;
            // 게임 오버 여부 확인
            if (map[y][x] == 2 || snake.contains(x + "," + y)) {
                // System.out.println("벽 여부 : " + (map[y][x] == 2) + " 몸 여부 : " + (snake.contains(x + "," + y)));
                break;
            }
            // 사과 여부 확인
            if (map[y][x] == 1) {
                snake.add(x + "," + y);
                map[y][x] = 0;
                // System.out.println("사과 발견 : " + x + "," + y + "으로 이동");
            } else {
                snake.poll();
                snake.add(x + "," + y);
                // System.out.println(x + "," + y + "으로 이동");
            }
            nX = x;
            nY = y;
        }
        System.out.println(second);
    }

    // =============== 테스트용 맵 출력 ===============
    static void PrintMap(int[][] map, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
