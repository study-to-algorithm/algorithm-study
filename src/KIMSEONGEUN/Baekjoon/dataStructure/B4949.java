package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.*;
import java.util.Stack;

// 문제: 균형잡힌 세상 (실버 4)
public class B4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {

            String line = br.readLine();
            if (line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean ok = true;


            for (int i = 0; i < line.length(); i++) {
                char chr = line.charAt(i);

                if (chr == '(' || chr == '[') {
                    stack.push(chr);
                } else if (chr == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ok = false;
                        break;
                    }
                    stack.pop();
                } else if (chr == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        ok = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (ok && stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
