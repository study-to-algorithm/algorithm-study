package KIMSEONGEUN.Baekjoon.dataStructure;

import java.util.*;

// 문제: 괄호의 값 (골드 5)
public class B2504 {

    public static void main(String[] args) {
        // () = 2, [] = 3, (값) = 2x값, [값] = 3x값
        // (()[[]])([]) => ()[[]] = 2 + 3x3 = 11, (()[[]]) = 2x11 = 22, ([]) = 2x3 = 6
        // 22+6 = 28

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        boolean ok = true;

        for (int i = 0; i < line.length(); i++) {
            char chr = line.charAt(i);

            if (chr == '(' || chr == '[') {
                charStack.push(chr);
            }
            else if (chr == ')') {
                if (charStack.peek() == '(') {
//                    charStack.pop()
                }
            }
        }
    }
}
