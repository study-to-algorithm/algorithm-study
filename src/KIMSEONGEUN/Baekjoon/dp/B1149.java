package KIMSEONGEUN.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (i == 1) {
                dp[i][0] = r;
                dp[i][1] = g;
                dp[i][2] = b;
            } else {
                dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = b + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        int ans = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(ans);
    }
}
