/*
문제 링크: https://www.acmicpc.net/problem/11726
시간: 176ms
메모리: 17780KB
접근 방법: 초기화 값을 설정하고 3부터 입력값 n까지의 값을 구하는 점화식을 세움
*/
import java.util.*;

public class B11726{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 2*n 타일의 n값

        int[] dp = new int[1001]; 

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);

    }
}