package KIMSEONGEUN.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1343 {

    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;

        StringBuilder sb = new StringBuilder();

            // 문자열 하나씩 확인하기
            for (int i = 0; i < str.length(); i++) {
                // 입력 받은 문자열 X 카운트하기
                char chr = str.charAt(i);
                if (chr == 'X') {
                    count++;
                } else {
                    if (count % 2 != 0) {
                        System.out.println(-1);
                        return;
                    }

                    while (count >= 4) {
                            sb.append("AAAA");
                            count -= 4;
                        }

                    while (count >= 2) {
                            sb.append("BB");
                            count -= 2;
                        }

                    // .이면 치환 후 . 출력
                    sb.append(".");

                    count = 0;
                }
            }

            if (count > 0) {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                while (count >= 4) {
                    sb.append("AAAA");
                    count -= 4;
                }

                while (count >= 2) {
                    sb.append("BB");
                    count -= 2;
                }

                count = 0;
            }


        System.out.println(sb);
    }
}
