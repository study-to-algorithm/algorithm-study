/*
[DP]
백준 1932번 정수 삼각형

1. 바로 아래
2. 아래 오른쪽

dp[i][j] = i번째 줄 j번째 칸까지 왔을 때의 최대 합

이전 줄에서 올 수 있는 경우:
1) (i-1, j-1)
2) (i-1, j)

=> 둘 중 최대값 + 현재 값
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int value = Integer.parseInt(st.nextToken());

                // 왼쪽
                if (j == 0) {
                    dp[i][j] = (i == 0) ? value : dp[i - 1][j] + value;
                }
                // 오른쪽
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + value;
                }
                // 가운데
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + value;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}
