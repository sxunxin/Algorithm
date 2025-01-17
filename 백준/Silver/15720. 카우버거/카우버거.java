import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 카우버거 - https://www.acmicpc.net/problem/15720

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int min = Math.min(B, Math.min(C, D));

        ArrayList<Integer> arrB = new ArrayList<>();
        ArrayList<Integer> arrC = new ArrayList<>();
        ArrayList<Integer> arrD = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arrB.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arrC.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            arrD.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrB, Collections.reverseOrder());
        Collections.sort(arrC, Collections.reverseOrder());
        Collections.sort(arrD, Collections.reverseOrder());

        int total = 0;
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < min; i++) {
            cnt += arrB.remove(0);
            cnt += arrC.remove(0);
            cnt += arrD.remove(0);
        }
        res = (int)(cnt * 0.9);
        total = cnt;
        cnt = 0;

        while (!arrB.isEmpty() || !arrD.isEmpty() || !arrC.isEmpty()) {
            if (!arrB.isEmpty()) {
                cnt += arrB.remove(0);
            }
            if (!arrD.isEmpty()) {
                cnt += arrD.remove(0);
            }
            if (!arrC.isEmpty()) {
                cnt += arrC.remove(0);
            }
        }

        System.out.println(total + cnt);
        System.out.println(res + cnt);

    }
}
