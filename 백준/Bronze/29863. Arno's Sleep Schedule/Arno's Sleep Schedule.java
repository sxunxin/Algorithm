import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // Arno's Sleep Schedule - https://www.acmicpc.net/problem/29863

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());

        int sum = t2 - t1;
        if (t1 > t2) sum += 24;
        
        System.out.println(sum);
    }
}
