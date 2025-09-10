import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    // 개미굴 - https://www.acmicpc.net/problem/14725

    static class Node {
        TreeMap<String, Node> child = new TreeMap<>();
    }

    public static class Trie {
        Node root = new Node();

        public void insert(String[] arr) {
            Node node = root;
            for (String name : arr) {
                node = node.child.computeIfAbsent(name, k -> new Node());
            }
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            dfs(root, 0, sb);
            System.out.println(sb);
        }

        private void dfs(Node node, int depth, StringBuilder sb) {
            for (Map.Entry<String, Node> e : node.child.entrySet()) {
                for (int i = 0; i < depth; i++) sb.append("--");
                sb.append(e.getKey()).append('\n');
                dfs(e.getValue(), depth + 1, sb);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            String[] arr = new String[K];
            for (int j = 0; j < K; j++) {
                arr[j] = st.nextToken();
            }
            trie.insert(arr);
        }

        trie.print();
    }
}