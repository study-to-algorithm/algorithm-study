package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 문제: 큐 (실버 4)
public class B10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int push = Integer.parseInt(st.nextToken());
                    queue.addLast(push);
                    break;
                    
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }

        }
        System.out.println(sb);
    }
}
