import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 이진 검색 트리 - https://www.acmicpc.net/problem/5639

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void addNode(int n) {
            if (n < this.value) {
                if (this.left == null) this.left = new Node(n);
                else this.left.addNode(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.addNode(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = Integer.parseInt(br.readLine());
        Node head = new Node(root);

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty())
                break;
            head.addNode(Integer.parseInt(input));
        }

        postOrder(head);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
