import java.util.Scanner;
public class Main {
    // 분해합 - https://www.acmicpc.net/problem/2231
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int ans = N;
        int ansMin = 0;

        for  (int i = 0; i < N; i++) {
            int temp = --ans;
            int sum = temp;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                if (ansMin == 0 || ans < ansMin) {
                    ansMin = ans;
                }
            }
        }

        System.out.println(ansMin);

    }
}
