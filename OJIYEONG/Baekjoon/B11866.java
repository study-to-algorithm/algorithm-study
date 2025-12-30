/*
[자료구조 / 시뮬레이션]
백준 11866번 요세푸스 문제 0

1번부터 N번까지 사람이 원형으로 앉아 있음
K번째 사람을 제거 -> 제거 순서 출력

- 큐에 1 ~ N 넣기
- K-1번: poll → offer (뒤로 이동)
- K번째: poll → 제거

출력 형식:
<3, 6, 2, 7, 5, 1, 4>
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll());

            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
