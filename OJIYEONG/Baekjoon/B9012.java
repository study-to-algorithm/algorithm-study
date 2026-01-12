/*
[자료구조 / 구현]
백준 9012번 괄호

- ( 는 +1
- ) 는 -1
- 중간에 count < 0 이 되면 올바르지 않은 괄호
- 끝났을 때 count == 0 이면 VPS
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine();
            int count = 0;
            boolean isValid = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    count++;
                } else { // ')'
                    count--;
                }

                // 닫는 괄호가 먼저 나옴
                if (count < 0) {
                    isValid = false;
                    break;
                }
            }

            // 모든 문자 처리 했는데 '('가 남아 있으면 실패
            if (count != 0) isValid = false;

            sb.append(isValid ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
