import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // D-Day - https://www.acmicpc.net/problem/1308

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year1 = Integer.parseInt(st.nextToken());
        int month1 = Integer.parseInt(st.nextToken());
        int day1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int year2 = Integer.parseInt(st.nextToken());
        int month2 = Integer.parseInt(st.nextToken());
        int day2  = Integer.parseInt(st.nextToken());

        if (year1 + 1000 < year2 ||
                (year1 + 1000 == year2 && month1 < month2) ||
                (year1 + 1000 == year2 && month1 == month2 && day1 <= day2)) {
            System.out.println("gg");
            return;
        }

        int D_day = getDay(year2, month2, day2) - getDay(year1, month1, day1);
        System.out.println("D-" + D_day);
    }

    public static int getDay(int year, int month, int day) {
        int days = 0;
        int[] months = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) months[1] = 29;

        for (int i = 1; i < year; i++) {
            days += (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) ? 366 : 365;
        }

        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }
        days += day;

        return days;
    }
}
