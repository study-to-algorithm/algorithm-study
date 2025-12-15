/*
[DP]
백준 1463번 1로 만들기

10을 1로 만드는 최소 횟수...
첫 단계(연산)은 셋 중 하나
/3 -> X못함
/2 -> 5
-1 -> 9

10 -> 1 최소 횟수 = min(9->1, 5->1) + 1
=> 현재 숫자의 최소 횟수 = 다음으로 가능한 숫자의 최소 횟수 + 1
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; // dp[i] : i 를 숫자 1로 만드는 최소 횟수
        dp[1] = 0; // 1은 이미 1이라 최소 횟수가 0

        for(int i = 2; i <= n; i++) {
            // 1 빼기
            dp[i] = dp[i-1] + 1;

            // 2 나누기
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3 나누기
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}