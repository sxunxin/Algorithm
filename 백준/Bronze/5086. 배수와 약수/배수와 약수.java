import java.util.Scanner;

public class Main {
    // 배수와 약수 - https://www.acmicpc.net/problem/5086
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int a =scanner.nextInt();
            int b =scanner.nextInt();

            if ( a == 0 && b == 0 )
                break;

            int check = 0;
            if (a > b) {
                for (int i = 1; i < a; i++) {
                    int tmp = b;
                    tmp *= i;
                    if (a == tmp) {
                        System.out.println("multiple");
                        check = 1;
                    }
                }
            } else {
                for (int i = 1; i < b; i++) {
                    int tmp = a;
                    tmp *= i;
                    if (b == tmp) {
                        System.out.println("factor");
                        check = 1;
                    }
                }
            }
            if (check == 0) {
                System.out.println("neither");
            }
        }

    }
}
