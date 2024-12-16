import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // 요세푸스 문제 0 - https://www.acmicpc.net/problem/11866
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue q = new LinkedList();
        Queue ans = new LinkedList();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < K; j++) {
                int temp = (int)q.remove();
                q.offer(temp);
            }
            ans.offer(q.remove());
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(ans.remove());
            if (i != N-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");


    }
}
