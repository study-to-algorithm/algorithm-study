import java.util.*;
import java.io.*;

public class B1149{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /*
         * dp[i][0] : i번째 집을 빨강(R)으로 칠했을 때의 최소 비용
         * dp[i][1] : i번째 집을 초록(G)으로 칠했을 때의 최소 비용
         * dp[i][2] : i번째 집을 파랑(B)으로 칠했을 때의 최소 비용
         *
         * dp[0][*]는 0으로 초기화되어 있으며,
         * 1번째 집 계산 시 기준값으로 사용됨
         */
        int[][] dp = new int[n + 1][3];

        // 1번 집부터 n번 집까지 순차적으로 DP 계산
        for (int i = 1; i <= n; i++) {

            // 각 집을 R, G, B로 칠하는 비용 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /*
             * 현재 집을 특정 색으로 칠하려면
             * 이전 집은 다른 두 색 중 하나여야 함
             */

            // 빨강
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;

            // 초록
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;

            // 파랑
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
        }

        // n번째 집을 R, G, B 중 어떤 색으로 칠했는지에 따른 최소 비용 출력
        System.out.println(
                Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]))
        );
    }
}