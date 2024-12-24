import java.util.Scanner;

public class Main {
    // 벌집 - https://www.acmicpc.net/problem/2292
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 1;
        int sum = 6;
        int cnt = 1;

        while (true) {
            if (n <= max)
                break;
            max += sum;
            sum += 6;
            cnt++;
        }

        System.out.println(cnt);

    }
}

