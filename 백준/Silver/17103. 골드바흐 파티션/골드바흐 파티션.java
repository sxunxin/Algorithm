

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 골드바흐 파티션 - https://www.acmicpc.net/problem/17103

    static boolean[] isPrime;

    static void isPrime_fun(){
        isPrime = new boolean[1000000 +1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (isPrime[i]){
                for (int j = i*i; j<= 1000000; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime_fun();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());

            for (int j = 2; j <= num/2; j++) {
                if (isPrime[j] && isPrime[num - j])
                    cnt++;
            }

            System.out.println(cnt);
        }
    }
}
