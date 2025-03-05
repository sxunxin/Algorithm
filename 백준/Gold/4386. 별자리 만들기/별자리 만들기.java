import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 별자리 만들기 - https://www.acmicpc.net/problem/4386

    static int[] parent;
    static Node[] stars;
    static ArrayList<Dist> list;

    public static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dist implements Comparable<Dist> {
        int start;
        int end;
        double weight;

        Dist(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Dist o) {
            if (weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        stars = new Node[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Node(x, y);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = distance(stars[i], stars[j]);

                list.add(new Dist(i, j, dist));
            }
        }
        Collections.sort(list);


        double ans = 0;
        for (int i = 0; i < list.size(); i++) {
            Dist dist = list.get(i);

            if (find(dist.start) != find(dist.end)) {
                ans += dist.weight;
                union(dist.start, dist.end);
            }
        }
        System.out.println(ans);
    }

    public static double distance(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}
