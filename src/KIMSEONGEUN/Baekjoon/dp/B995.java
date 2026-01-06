package KIMSEONGEUN.Baekjoon.dp;

import java.util.Scanner;

public class B995 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        // dp[i] = 1,2,3을 더해서 i의 합으로 나타내는 방법의 수
        int[] dp = new int[11];

        // 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (T > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
            T--;
        }
    }
}
