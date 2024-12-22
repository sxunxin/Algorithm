import java.util.Scanner;

public class Main {
    // 세 막대 - https://www.acmicpc.net/problem/14215
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int side1 = scanner.nextInt();
        int sideMax = side1;
        int side2 = scanner.nextInt();
        if (side2 > sideMax) sideMax = side2;
        int side3 = scanner.nextInt();
        if (side3 > sideMax) sideMax = side3;

        if (sideMax < (side1 + side2 + side3 - sideMax))
            System.out.println(side1 + side2 + side3);
        else
            System.out.println((side1 + side2 + side3 - sideMax) * 2 - 1);

    }
}
