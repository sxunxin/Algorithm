import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // ISBN - https://www.acmicpc.net/problem/6810

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 91;
        sum += Integer.parseInt(br.readLine());
        sum += Integer.parseInt(br.readLine()) * 3;
        sum += Integer.parseInt(br.readLine());
        System.out.println("The 1-3-sum is " + sum);
    }
}
