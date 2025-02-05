import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    // 소수의 연속합 - https://www.acmicpc.net/problem/1644

    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            isPrime(i);
        }
        arr.add(0);

        int p1 = 0, p2 = 0;
        int sum = 0, cnt = 0;

        while (p1 <= p2 && p2 < arr.size()) {
            if (sum < N) {
                sum += arr.get(p2++);
            } else {
                if (sum == N) cnt++;
                sum -= arr.get(p1++);
            }
        }
        System.out.println(cnt);
    }

    public static void isPrime(int num) {
        if (num < 2) return;
        if (num == 2) {
            arr.add(num);
            return;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return;
        }
        arr.add(num);
    }
}
