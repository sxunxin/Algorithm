import java.util.Scanner;

public class Main {
    // 팰린드롬인지 확인하기 - https://www.acmicpc.net/problem/10988
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int len = str.length() / 2;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}
