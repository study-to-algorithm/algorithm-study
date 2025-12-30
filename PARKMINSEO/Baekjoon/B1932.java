import java.util.*;
        import java.io.*;
/*
 * 실버 1 dp
 * 삼각형 모양으로 내려 갈때 대각선에 있는 값들로만 이동할 수 있음
 * dp[][] = 이 위치로 이동할 때 얻을 수 있는 누적 합
 * 왼쪽 끝에 있는 경우, dp[i - 1][j - 1], dp[i - 1][j] 이 값을 비교할 수 없음 -> dp[i - 1][j - 1]이 없으니깐
 * 오른족 끝에 있는 경우도 마찬가지로, dp[i - 1][j - 1], dp[i - 1][j] 이 값을 비교할 수 없음 -> dp[i - 1][j]가 없으니깐
 */

public class B1932{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 크

        int[][] dp = new int[n + 1][n + 1]; // 초기화
        int[][] arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); // 값 저장
            }
        }

        dp[1][1] = arr[1][1]; // 처음은 첫번째 줄에 있는 값

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if(j == 1){
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }
        }

        int max = -1;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}