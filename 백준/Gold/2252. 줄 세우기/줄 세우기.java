import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 줄 세우기 - https://www.acmicpc.net/problem/2252

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegreeCnt = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegreeCnt[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < inDegreeCnt.length; i++) {
            if (inDegreeCnt[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int nNode = queue.poll();
            sb.append(nNode).append(" ");

            ArrayList<Integer> nList = graph.get(nNode);
            for (Integer i : nList) {
                if (--inDegreeCnt[i] == 0) queue.add(i);
            }
        }

        System.out.println(sb);
    }
}
