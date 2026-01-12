/*
[DP]
백준 1003번 피보나치 함수

- fibonacci(n)을 호출했을 때 0과 1이 출력되는 횟수
- 같은 계산이 반복되므로 DP 사용
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 문제 조건상 n은 최대 40
        int[][] dp = new int[41][2];

        // 초기값
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;

        // 미리 DP 계산
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
