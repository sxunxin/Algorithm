import java.util.Scanner;

public class Main {
    // 분수 찾기 - https://www.acmicpc.net/problem/1193
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int line = 1;
        int lineEnd = 1;

        while (lineEnd < X) {
            line += 1;
            lineEnd += line;
        }

        int num = lineEnd - X;

        if (line % 2 == 0) {
            System.out.println((line - num) + "/" + (num+1));
        } else {
            System.out.println((num+1) + "/" + (line - num));
        }
    }
}
