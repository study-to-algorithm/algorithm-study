/*
[DP]
백준 2579번 계단 오르기

마지막 계단(n번)에 도착했을 때 얻을 수 있는 최대 점수 구하기
- 한 번에 1칸 또는 2칸 이동 가능
- 연속으로 3개의 계단을 밟을 수 없음
- 마지막 계단은 반드시 밟아야 함

1)
i-2 -> i (2칸 점프)
dp[i-2] + score[i]

2)
i-3 -> i-1 -> i (1칸 + 1칸)
dp[i-3] + score[i-1] + score[i]

=> 현재 계단의 최대 점수 = 이전에 올 수 있는 경우들 중 최대값
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        dp[1] = score[1];

        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[n]);
    }
}
