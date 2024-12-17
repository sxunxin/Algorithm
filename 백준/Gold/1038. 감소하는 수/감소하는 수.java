import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    // 감소하는 수 - https://www.acmicpc.net/problem/1038

    public static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                downNum(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }


    }

    public static void downNum(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            downNum(num * 10 + i, idx + 1);
        }
    }
}

