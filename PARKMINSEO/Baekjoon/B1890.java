import java.util.*;
import java.io.*;
/*
 * 실버 1 dp
 * dp = 현재 여기에 도달할 수 있는 경우의 수
 * dp[i][j]부터 시작해서 arr[i][j] 수만큼 더해주면 각 위치에 도달하는 경우의 수가 자연스럽게 누적되는 방식
 */

public class B1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1L;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++) {
                if(dp[i][j] == 0) continue; // 이 칸에 도달하는 경우가 없을 경우
                if(i == n && j == n) continue; // 종착점에 도달한 경우
                int a = arr[i][j]; // 이동할 값
                if(i + a <= n){ // 길이를 벗어나지 않을 경우에만
                    dp[i + a][j] += dp[i][j];
                }
                if(j + a <= n){ // 길이를 벗어나지 않을 경우에만
                    dp[i][j + a] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}