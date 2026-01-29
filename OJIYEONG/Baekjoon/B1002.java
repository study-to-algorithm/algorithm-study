/*
[수학]
백준 1002번 터렛


*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;

            int distSq = dx * dx + dy * dy;
            int sumR = r1 + r2;
            int diffR = Math.abs(r1 - r2);

            if (distSq == 0 && r1 == r2) {
                sb.append(-1);
            } else if (distSq > sumR * sumR) {
                sb.append(0);
            } else if (distSq < diffR * diffR) {
                sb.append(0);
            } else if (distSq == sumR * sumR) {
                sb.append(1);
            } else if (distSq == diffR * diffR) {
                sb.append(1);
            } else {
                sb.append(2);
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
