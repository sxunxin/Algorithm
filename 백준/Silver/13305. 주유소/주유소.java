

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 주요소 - https://www.acmicpc.net/problem/13305

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N];
        int[] value = new int[N];
        int point = 0;
        long cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        while (point < N - 1) {
            if (value[point] < value[point + 1]) {
                value[point + 1] = value[point];
            }
            cnt += (long) distance[point] * value[point];
            point++;
        }

        System.out.println(cnt);
    }
}
