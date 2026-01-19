import java.io.*;
import java.util.*;

/**
 * 실버 1 dp
 * 규칙을 정리하면 그냥 인접한 집들의 경우 색상을 다르면 된다는 뜻
 * 이전에 선택한 색상과 다른 색상들로 최소값 비교해서 계산
 */

public class B1149 {
    static int n;
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];
        arr = new int[n + 1][3];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }

        for(int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));

    }
}