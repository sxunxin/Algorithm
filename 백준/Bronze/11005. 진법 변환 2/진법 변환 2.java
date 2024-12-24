import java.util.Scanner;

public class Main {
    // 진법 변환 2 - https://www.acmicpc.net/problem/11005
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.print(Integer.toString(num1,num2).toUpperCase());
    }
}
