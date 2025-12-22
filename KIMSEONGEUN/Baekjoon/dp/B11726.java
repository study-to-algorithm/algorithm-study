package KIMSEONGEUN.Baekjoon.dp;

import java.util.Scanner;

public class B11726 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // dp[i] = 가로 길이가 i일 때 타일을 채우는 경우의 수
        int[] dp = new int[num + 1];

        // 초기값 설정
        dp[1] = 1;

        if (num >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[num]);
    }
}
