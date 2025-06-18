import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // Secret Location - https://www.acmicpc.net/problem/5340

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("Latitude ");
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            sb.append((str.charAt(str.length() - 1) == ' ') ? str.length() - 1 : str.length());

            if (i != 2) sb.append(":");
        }

        sb.append("\nLongitude ");
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            sb.append((str.charAt(str.length() - 1) == ' ') ? str.length() - 1 : str.length());

            if (i != 2) sb.append(":");
        }
        System.out.println(sb);
    }
}
