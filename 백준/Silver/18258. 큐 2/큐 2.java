import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 큐2 - https://www.acmicpc.net/problem/18258

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue q = new LinkedList();
        int num = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" -> {
                    num = Integer.parseInt(st.nextToken());
                    //scanner.nextLine();
                    q.add(num);
                }
                case "pop" -> {
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.remove()).append("\n");
                    }
                }
                case "size" -> sb.append(q.size()).append("\n");
                case "empty" -> sb.append(q.isEmpty() ? "1" : "0").append("\n");
                case "front" -> {
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                }
                case "back" -> {
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(num).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
