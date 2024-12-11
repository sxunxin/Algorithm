import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 알고리즘 수업 - 피보나치 수 1 - https://www.acmicpc.net/problem/24416

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n) + " " + (n-2));
    }

    public static int fibonacci(int n) {
        int[] fibos = new int[n+1];
        fibos[1]=fibos[2]=1;
        for(int i=3;i<=n;i++) {
            fibos[i]=fibos[i-1]+fibos[i-2];
        }
        return fibos[n];
    }

}
