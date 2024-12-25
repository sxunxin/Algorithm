import java.util.Scanner;

public class Main {
    // 색종이 - https://www.acmicpc.net/problem/2563
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[100][100];
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            int startX = scanner.nextInt()-1;
            int startY = scanner.nextInt()-1;

            for (int x = startX; x < startX+10; x++) {
                for (int y = startY; y < startY+10; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1)
                    cnt++;
            }
        }
        System.out.println(cnt);

    }
}
