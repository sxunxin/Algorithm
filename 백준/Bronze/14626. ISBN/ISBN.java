import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // ISBN - https://www.acmicpc.net/problem/14626

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 0;
        int idx = -1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                idx = i;
            } else {
                if (i % 2 == 1) sum += (str.charAt(i) - '0') * 3;
                else sum += (str.charAt(i) - '0');
            }
        }
        if (idx == -1){
            int ans = 10 - (sum % 10);
            System.out.println(ans == 10 ? 0 : ans);
        }
        else {
            int checkNum = str.charAt(12) - '0';
            int ans = 0;
            while (true) {
                int tmpSum = 10 - (((idx % 2 == 1 ? 3 : 1) * ans + sum) % 10);
                tmpSum = tmpSum == 10 ? 0 : tmpSum;
                if (tmpSum == checkNum) {
                    break;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}


