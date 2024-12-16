import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 카드2 - https://www.acmicpc.net/problem/2164
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue q = new LinkedList();
        Queue ans = new LinkedList();

        if (N == 1) {
            System.out.println("1");
            System.exit(0);
        }

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (true) {
            q.remove();
            if (q.size() == 1) {
                System.out.println(q.remove());
                break;
            }
            q.offer(q.remove());
        }


    }
}
