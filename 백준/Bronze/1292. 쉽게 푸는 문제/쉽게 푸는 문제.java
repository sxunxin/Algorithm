import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 쉽게 푸는 문제 - https://www.acmicpc.net/problem/1292

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        list.add(0);
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(i + 1);
            }
        }

        for (int i = A; i <= B; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
