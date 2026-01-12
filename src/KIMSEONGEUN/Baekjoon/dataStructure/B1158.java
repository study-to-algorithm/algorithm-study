package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제: 요세푸스 문제 (실버 4)
public class B1158 {

    /*
     * 원형, 반복 / 순서 유지 => 요세푸스
     * => 큐 사용
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        sb.append("<");

        while (!q.isEmpty()) {

            for (int i = 1; i <= k - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll());
            if (!q.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }
}
