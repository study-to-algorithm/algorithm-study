package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문제: 쇠막대기
public class B10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c); // ( 일 경우 막대가 시작
            } else {
                stack.pop(); // ) 일 경우 막대가 끝

                // () 이면 현재 시작한 막대기만큼 조각 증가
                if (str.charAt(i - 1) == '(') {
                    count += stack.size();
                } else { // ) 일 경우에 막대기 끝
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
