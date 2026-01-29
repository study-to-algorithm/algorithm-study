/*
[문자열(구현)]
백준 2941번 크로아티아 알파벳

- dz=는 3글자 -> 먼저 검사
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count = 0;
        int i = 0;

        while (i < s.length()) {

            if (i + 2 < s.length() && s.charAt(i) == 'd'
                    && s.charAt(i + 1) == 'z'
                    && s.charAt(i + 2) == '=') {
                count++;
                i += 3;
            }

            else if (i + 1 < s.length()) {
                String two = s.substring(i, i + 2);

                if (two.equals("c=") || two.equals("c-") ||
                        two.equals("d-") || two.equals("lj") ||
                        two.equals("nj") || two.equals("s=") ||
                        two.equals("z=")) {
                    count++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            }

            else {
                count++;
                i++;
            }
        }

        System.out.print(count);
    }
}
