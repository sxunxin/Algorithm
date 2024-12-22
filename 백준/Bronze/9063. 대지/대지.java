import java.util.Scanner;

public class Main {
    // 대지 - https://www.acmicpc.net/problem/9063
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int xMin = 100000;
        int yMin = 100000;
        int xMax = -100000;
        int yMax = -100000;

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (xMax < x) xMax = x;
            if (xMin > x) xMin = x;
            if (yMax < y) yMax = y;
            if (yMin > y) yMin = y;
        }

        System.out.println((xMax-xMin)*(yMax-yMin));
    }
}
