import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 날짜 계산 - https://www.acmicpc.net/problem/1476

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = 1;
        int tmpE = 1;
        int tmpS = 1;
        int tmpM = 1;

        while (E != tmpE || S != tmpS || M != tmpM) {
            year++;
            tmpM++;
            tmpE++;
            tmpS++;

            if (tmpE >= 16) tmpE = 1;
            if (tmpS >= 29) tmpS = 1;
            if (tmpM >= 20) tmpM = 1;
        }

        System.out.println(year);
    }
}
