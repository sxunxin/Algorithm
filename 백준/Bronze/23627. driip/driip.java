import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // driip - https://www.acmicpc.net/problem/23627

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (!str.contains("driip")) {
            System.out.println("not cute");
            return;
        }

        String testStr = str.substring(str.length() - 5);

        if (testStr.contains("driip")) System.out.println("cute");
        else System.out.println("not cute");
    }
}
