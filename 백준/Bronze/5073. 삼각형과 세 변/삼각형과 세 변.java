import java.util.Scanner;

public class Main {
    // 삼각형과 세 변 - https://www.acmicpc.net/problem/5073
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int side1 = scanner.nextInt();
            int sideMax = side1;
            int side2 = scanner.nextInt();
            if (side2 > sideMax) sideMax = side2;
            int side3 = scanner.nextInt();
            if (side3 > sideMax) sideMax = side3;

            if (side1 == 0 && side2 == 0 && side3 == 0) break;

            if (sideMax < (side1 + side2 + side3 - sideMax)) {
                if (side1 == side2 && side2 == side3) System.out.println("Equilateral");
                else if (side1 == side2 || side2 == side3 || side3 == side1) System.out.println("Isosceles");
                else System.out.println("Scalene");
            } else System.out.println("Invalid");
        }
    }
}
