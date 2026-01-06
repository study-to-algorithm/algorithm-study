import java.io.*;
import java.util.*;

public class B1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 처음으로 받은 숫자 1개
        int[][] t = new int[n][n];
        long[][] dp = new long[n][n];

        // 입력받은 값 2차원 배열에 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작점은 1로 초기화
        dp[0][0] = 1;

        // DP 진행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 도달할 수 없는 칸이면 스킵
                if (dp[i][j] == 0) continue;

                int jump = t[i][j];

                // 도착 지점이거나 더 이상 이동 불가
                if (jump == 0) continue;

                // 오른쪽 이동
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }

                // 아래 이동
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
            }
        }

        // 도착 지점까지의 경우의 수 출력
        System.out.println(dp[n - 1][n - 1]);
    }
}
