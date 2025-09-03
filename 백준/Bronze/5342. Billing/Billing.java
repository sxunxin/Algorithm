import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // Billing - https://www.acmicpc.net/problem/5342

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double total = 0;

        while (true) {
            String input = br.readLine();
            if (input.equals("EOI")) break;

            switch (input) {
                case "Paper": total += 57.99; break;
                case "Printer": total += 120.50; break;
                case "Planners": total += 31.25; break;
                case "Binders": total += 22.50; break;
                case "Calendar": total += 10.95; break;
                case "Notebooks": total += 11.20; break;
                case "Ink": total += 66.95; break;
                default: total += 0; break;
            }
        }

        System.out.printf("$%.2f", total);
    }
}
