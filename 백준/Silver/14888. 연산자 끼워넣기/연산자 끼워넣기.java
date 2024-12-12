import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 연산자 끼워넣기 - https://www.acmicpc.net/problem/14888

    public static int[] num;
    public static int[] operator = new int[4];
    public static int N;
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int number, int index) {
        if (index == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:	dfs(number + num[index], index + 1);	break;
                    case 1:	dfs(number - num[index], index + 1);	break;
                    case 2:	dfs(number * num[index], index + 1);	break;
                    case 3:	dfs(number / num[index], index + 1);	break;

                }
                operator[i]++;
            }
        }
    }
}
