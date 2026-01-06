/*
[DP]
백준 1890번 점프

가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로

각 칸에 적힌 숫자만큼 아래, 오른쪽으로만 이동 가능

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작 위치

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (dp[i][j] == 0) continue;
                if (map[i][j] == 0) continue;

                int jump = map[i][j];

                // 아래
                if (i + jump < N) {
                    dp[i + jump][j] += dp[i][j];
                }

                // 오른쪽
                if (j + jump < N) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
