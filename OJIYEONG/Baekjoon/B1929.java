/*
[]
백준 1929번 소수 구하기

- 소수 아닌 수 우선 제거
- i*i <= N 까지만 검사
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) continue;

            for (int j = i * i; j <= N; j += i) {
                prime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}
