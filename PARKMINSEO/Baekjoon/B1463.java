import java.util.*;
import java.io.*;
/*
 *
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
이 공식을 이용해서 1을 만드는 연산의 최솟값을 구하는 문제
 */

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1]; // 초기화
        dp[0] = dp[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i % 6 == 0){ // 6으로 나누어 질때는
                // 3으로 나누는 경우, 2로 나누는 경우, 1을 뺀 경우 중에서 가장 작은 값으로 선택
                // 이전 상태의 연산 횟수에서 이번에 연산한 횟수를 더하기 위해 모든 경우에 1을 더함
                dp[i] = Math.min(dp[i/3], Math.min(dp[i/2], dp[i-1])) + 1;
            }
            else if(i % 3 == 0){ // 3으로 나눌 경우에는 3으로 나누는 경우, 1을 빼는 경우 중 선택
                dp[i] = Math.min(dp[i/3], dp[i - 1]) + 1;
            }
            else if(i % 2 == 0){ // 2로 나눌 경우에는 2로 나누는 경우, 1을 빼는 경우 중 선택
                dp[i] = Math.min(dp[i/2], dp[i - 1]) + 1;
            }
            else{ // 6, 2, 3으로 나누어지지 않는 경우에는 1을 뺀다
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}