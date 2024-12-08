import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // ATM - https://www.acmicpc.net/problem/11399
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sum += arr[i] * (N - i);
        }
        System.out.println(sum);
    }
}
