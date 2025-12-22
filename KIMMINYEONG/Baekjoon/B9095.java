import java.util.*;

/* 문제 링크 : https://www.acmicpc.net/problem/9095
   시간 : 164ms
   메모리 : 17728KB
   접근 방법: DP
*/

public class B9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스의 개수 T

        int[] dp = new int[11]; // 1부터 10까지의 합을 구하기 위한 dp 배열

        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for(int i = 4; i<11; i++){ // n은 양수이며 11보다 작다
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int j=0; j<t; j++) {
			int n = sc.nextInt();
			
			System.out.println(dp[n]);
		}
    }
    
}
