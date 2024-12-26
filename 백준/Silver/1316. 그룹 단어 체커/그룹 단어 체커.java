import java.util.Scanner;

public class Main {
    // 그룹 단어 체커 - https://www.acmicpc.net/problem/1316
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt = 0;
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            int[] arr = new int[26];

            for (int j = 0; j < str.length(); j++) {
                if (j < str.length()-1 && str.charAt(j) != str.charAt(j+1)) {
                    arr[(int) str.charAt(j) - 97] += 1;
                    if (arr[(int) str.charAt(j) - 97] == 2) {
                        cnt++;
                        break;
                    }
                }
                if ( j == str.length() -1 ) {
                    arr[(int) str.charAt(j) - 97] += 1;
                    if (arr[(int) str.charAt(j) - 97] == 2) {
                        cnt++;
                        break;
                    }
                }
            }

        }
        System.out.println(N-cnt);
    }
}
