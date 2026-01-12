package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제: 풍선 터뜨리기 (실버 3)
public class B2346 {

    /*
     * 풍선 안의 값과 인덱스 모두 있어야하므로 Deque<int[]> 사용
     * Queue는 단방향, Deque는 양방향이므로 원형 구조에서 사용
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            // deque.offer(new int[]{풍선번호, 이동값});
            deque.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {
            // 현재 풍선 터뜨리기 및 출력
            int[] temp = deque.pollFirst();
            sb.append(temp[0]).append(" ");

            if (deque.isEmpty()) break;

            if (temp[1] > 0) {
                for (int i = 0; i < temp[1] - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -temp[1]; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}
