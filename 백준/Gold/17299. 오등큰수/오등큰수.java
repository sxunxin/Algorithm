import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 오등큰수 - https://www.acmicpc.net/problem/17299

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cntArr = new int[N];
        int[] cnt = new int[1000001];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }
        for (int i = 0; i < N; i++) {
            cntArr[i] = cnt[arr[i]];
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && cntArr[stack.peek()] < cntArr[i]) {
                int temp = stack.pop();
                cntArr[temp] = cntArr[i];
                arr[temp] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
