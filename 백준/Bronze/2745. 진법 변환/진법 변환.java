import java.util.Scanner;

public class Main {
    // 진법 변환 - https://www.acmicpc.net/problem/2745
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        int num2 = scanner.nextInt();
        System.out.println(Integer.parseInt(num1,num2));
    }
}
