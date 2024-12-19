

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 대표값2 - https://www.acmicpc.net/problem/2587
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            sum += num;
            arr[i] = num;
        }
        int avg = sum / 5;
        Arrays.sort(arr);
        System.out.println(avg);
        System.out.println(arr[2]);
    }
}
