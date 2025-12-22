/*
문제 링크: https://www.acmicpc.net/problem/2579
시간: 188ms
메모리: 17788KB
접근 방법: DP(동적계획법)
           Top-Down = 재귀호출로 dp 배열 채우기
           Bottom-Up = 반복문으로 dp 배열 채우기
*/
import java.util.*;

public class B2579{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1]; // arr[0]은 1층을 의미 즉 출발지점, 고로 n층까지 가려면 n+1크기 필요
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }

        // 초기값 설정
        dp[0] = 0; // 배열의 기본값은 0이므로 생략 가능
        dp[1] = arr[1];

        if(n>=2){
            dp[2] = arr[1] + arr[2];
        } // n이 2 이상일 때만 dp[2] 초기값 설정

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        // dp[i-2] : i-2층에서 한번에 2칸 점프
        // dp[i-3] + arr[i-1] : i-3층에서 2칸 점프 후 i-1층에서 1칸 점프
        // arr[i] : i층에서의 계단 점수 더하기
        // 둘 중 큰 값을 dp[i]에 저장
        
        /* 궁금증 : 왜 dp[i-1]이 아니라 arr[i-1]인가?
         연속 3칸을 밟을 수 없다는 제한이 존재 
         즉 DP[i-1]을 하면 i-1번째 계단까지 올 수 있는 최고 점수를 뜻함
         그럼 DP[i-1]까지 몇 번째 계단을 밟았는지 알 수 없음
         
         그러므로 dp[i-1]이 아닌 arr[i-1]을 사용하여 제한을 걸어둔다는 식으로 이해*/

        System.out.println(dp[n]);
    }
}