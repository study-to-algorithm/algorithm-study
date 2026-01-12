package KIMSEONGEUN.Baekjoon.dp;

import java.util.Scanner;

public class B1463 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // dp[i] = i를 1로 만드는데 필요한 최소 연산 횟수
        int[] dp = new int[num + 1];

        // x % 3 == 0 -> x / 3
        // x % 2 == 0 -> x / 2
        // x - 1

        // 초기값 설정
        dp[1] = 0;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[num]);
    }
}
