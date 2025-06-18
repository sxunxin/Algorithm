import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // Previous Level - https://www.acmicpc.net/problem/28453

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ranking(Integer.parseInt(st.nextToken()));
        }

    }

    static void ranking(int M) {
        if (M == 300) {
            System.out.print("1 ");
        } else if (M >= 275) {
            System.out.print("2 ");
        } else if (M >= 250) {
            System.out.print("3 ");
        } else {
            System.out.print("4 ");
        }
    }
}
