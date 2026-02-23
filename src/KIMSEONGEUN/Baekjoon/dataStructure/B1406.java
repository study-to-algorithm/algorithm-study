package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.*;
import java.util.*;

// 문제: 에디터 (실버 2)
public class B1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // 커서 맨 뒤로
        ListIterator<Character> cursor = list.listIterator(list.size());

        for (int i = 0; i < num; i++) {
            // L: 커서를 왼쪽으로 한 칸
            // D: 커서를 오른쪽으로 한칸
            // B: 커서 왼쪽에 있는 문자를 삭제 (커서가 문장의 맨 앞이면 무시)
            // P $ : $라는 문자를 커서 왼쪽에 추가

            String line = br.readLine();

            char cmd = line.charAt(0);

            if (cmd == 'L') {
                if (cursor.hasPrevious()) cursor.previous();
            }
            else if (cmd == 'D') {
                if (cursor.hasNext()) cursor.next();
            }
            else if (cmd == 'B') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (cmd == 'P') {
                cursor.add(line.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char i : list) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}
