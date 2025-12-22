import  java.util.*;

/*
문제 링크: https://www.acmicpc.net/problem/1463
시간: ms
메모리: KB
접근 방법: DP(동적계획법)
*/

public class B1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[1] = 0; //1로 만들기 문제이므로 n=1일 때는 연산 0번

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1; //i에서 1을 빼는 연산 즉, 한번 연산을 했으니 +1을 하게 됨

            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1); //2로 나누는 연산
            }

            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1); //3으로 나누는 연산
            }
        }

        System.out.println(dp[n]);
    }
}
