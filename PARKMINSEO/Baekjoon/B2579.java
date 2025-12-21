import java.util.*;
import java.io.*;
/*
 * 실버 3 dp 문제 해결 방법
- dp값에 저장된 값은 i번째 계단을 반드시 밟았을 때 얻을 수 있는 최대 점수
- i 번째의 계단을 밟을 수 있는 경우의 수는 2가지
    1. i - 2 -> i로 한번에 2 계단을 오른것
        i-1을 밟을 경우는 완전히 배제 -> 연속 3개의 계단 검사 불필요
    2. i - 3 -> i - 1 -> i
        i - 2를 밟을 경우는 완전히 배제 -> 마찬가지로 연속 3개의 계단 검사 불필요
- 이 2가지 경우를 비교해서 큰 값이 현재 계단을 밟았을 때의 최댓값
 */

public class B2579{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1]; // 초기화
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        dp[0] = arr[0]; // 처음은 널값
        dp[1] = arr[1]; // 첫번째 계단일 경우(시작점 무조건 포함)

        if(n >= 2){ // 계단이 2개 밖에 없을 경우 예외 처리
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[n]);
    }
}