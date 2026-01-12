package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 문제: 덱 (실버 4)
public class B10866 {

    public static void main(String[] args) throws IOException {

        Deque<Integer> deq = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {

                case "push_front":
                    int x = Integer.parseInt(st.nextToken());
                    deq.offerFirst(x);
                    break;

                case "push_back":
                    int y = Integer.parseInt(st.nextToken());
                    deq.offerLast(y);
                    break;

                case "pop_front":
                    if (deq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deq.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    if (deq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deq.pollLast()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(deq.size()).append("\n");
                    break;

                case "empty":
                    if (deq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                case "front":
                    if (deq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deq.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (deq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deq.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
