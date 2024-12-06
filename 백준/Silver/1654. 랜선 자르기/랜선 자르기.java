import java.util.Scanner;
public class Main {
    // 랜선 자르기 - https://www.acmicpc.net/problem/1654
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr = new int[K];
        long max = 0;
        long min = 0;
        long mid = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = scanner.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;

        while (min < max) {
            mid = (max + min) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (arr[i] / mid);
            }
            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
