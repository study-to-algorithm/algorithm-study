/*
[DP]
백준 17484번 진우의 달 여행 (Small)

맨 위 → 맨 아래까지 이동할 때 소모 연료의 최소값 구하기

- 아래쪽으로만 이동
- 방향은 3가지
  1) 왼쪽 아래
  2) 바로 아래
  3) 오른쪽 아래
- 같은 방향을 연속해서 사용할 수 없음


dp[r][c][d]
= r행 c열에 도착했을 때
  마지막에 사용한 방향이 d인 경우의 최소 연료

이전 위치:
- d = 0 (왼쪽 아래)
  → 이전은 (r-1, c+1), 이전 방향은 1 or 2
- d = 1 (아래)
  → 이전은 (r-1, c),   이전 방향은 0 or 2
- d = 2 (오른쪽 아래)
  → 이전은 (r-1, c-1), 이전 방향은 0 or 1

=> 같은 방향 연속 사용 금지

마지막 행에서 dp[N-1][c][d] 중 최소값
*/

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[r][c][d]
        int[][][] dp = new int[N][M][3];

        // 초기화
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(dp[r][c], INF);
            }
        }

        // 시작점: 이전 방향이 없으므로 모든 방향 가능
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                dp[0][c][d] = map[0][c];
            }
        }

        // DP
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {

                // 1) 왼쪽 아래 (←↓)
                if (c + 1 < M) {
                    dp[r][c][0] = Math.min(
                            dp[r-1][c+1][1],
                            dp[r-1][c+1][2]
                    ) + map[r][c];
                }

                // 2) 아래 (↓)
                dp[r][c][1] = Math.min(
                        (c < M ? dp[r-1][c][0] : INF),
                        (c < M ? dp[r-1][c][2] : INF)
                ) + map[r][c];

                // 3) 오른쪽 아래 (↓→)
                if (c - 1 >= 0) {
                    dp[r][c][2] = Math.min(
                            dp[r-1][c-1][0],
                            dp[r-1][c-1][1]
                    ) + map[r][c];
                }
            }
        }

        int answer = INF;
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N-1][c][d]);
            }
        }

        System.out.println(answer);
    }
}
