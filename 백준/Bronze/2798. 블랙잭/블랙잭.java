import java.util.Scanner;

public class Main {
    // 블랙잭 - https://www.acmicpc.net/problem/2798
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] list = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextInt();
        }

        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    int tempMax = list[i] + list[j] + list[k];
                    if (tempMax > max && tempMax <= M) max = tempMax;
                }
            }
        }
        System.out.println(max);
    }
}
