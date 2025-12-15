/*
[자료구조(스택)]
백준 10828번 스택

stack / ArrayList / Deque 사용 가능
-> 근데 그냥 백준 같은 문제에서는 Deque로만 다 풀어도 괜찮음

출력 횟수 많아지면 하나씩 println 하는 것보다
stringbuilder에 append 했다가 한 번에 출력하는게 나음
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                stack.push(x);

            } else if (cmd.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");

            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append("\n");

            } else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");

            } else if (cmd.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");

            }
        }

        System.out.println(sb.toString());
    }
}