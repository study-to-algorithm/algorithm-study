package KIMSEONGEUN.Baekjoon.dataStructure;

import java.util.*;

// 문제: 쇠막대기 (실버 2)
public class B10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            char chr = line.charAt(i);

            if (chr == '(') {
                stack.push(chr);
            }
            else if (chr == ')') {
                stack.pop();

                if (line.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    // 막대기 끝
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
