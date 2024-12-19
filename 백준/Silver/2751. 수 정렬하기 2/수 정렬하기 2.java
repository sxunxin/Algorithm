import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // 수 정렬하기 2 - https://www.acmicpc.net/problem/2751
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for (int i : arr) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);

    }
}
