import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 인간-컴퓨터 상호작용 - https://www.acmicpc.net/problem/16139

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[S.length()+1][26];

        for (int i = 1; i <= S.length(); i++) {
            int chNumber = S.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                int cnt = arr[i - 1][j];
                arr[i][j] = (j == chNumber ? ++cnt : cnt);
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int P1 = Integer.parseInt(st.nextToken());
            int P2 = Integer.parseInt(st.nextToken())+1;

            sb.append(arr[P2][a] - arr[P1][a]).append('\n');
        }

        System.out.println(sb);
    }
}
