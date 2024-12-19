import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // 소트인사이드 - https://www.acmicpc.net/problem/1427
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int len = (int)Math.log10(num) + 1;
        Integer[] arr = new Integer[len];

        for (int i = 0; i < len; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
        }
    }
}
