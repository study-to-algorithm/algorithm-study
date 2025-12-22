package KIMSEONGEUN.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {

    public static void main() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // 각 계단의 점수 배열
        int[] score = new int[num];

        for (int i = 0; i < num; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // i번째 계단에 도착했을 때의 최대 점수
        int[] dp = new int[num];

        // 경우의 수 2가지
        // 1) i-2번째 -> i번째
        // 2) i-3번째 -> i-1번째 -> i번째

        // 초기값 설정
        dp[0] = score[0];

        if (num > 1) {
            dp[1] = score[1] + score[0];
        }

        if (num > 2) {
            dp[2] = Math.max(
                    score[0] + score[2],
                    score[1] + score[2]
            );
        }

        for (int i = 3; i < num; i++) {
            dp[i] = Math.max(
                    dp[i-2] + score[i],
                    dp[i-3] + score[i-1] + score[i]
            );
        }

        System.out.println(dp[num-1]);
    }
}
