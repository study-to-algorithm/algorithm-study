package KIMSEONGEUN.Baekjoon.dp;

import java.util.Scanner;

public class B2748 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        long[] dp = new long[num + 1];

        // 초기값 설정
        dp[0] = 0;

        if (num >= 1) {
            dp[1] = 1;
        }

        // i-2 + i-1 = i
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[num]);
    }
}
