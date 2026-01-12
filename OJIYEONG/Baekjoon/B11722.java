/*
[DP]
백준 11722번 가장 긴 감소하는 부분 수열

값이 점점 감소하는 부분 수열 중 가장 긴 수열의 길이

부분 수열이라 연속일 필요X -> 순서만 유지

dp[i] = i번째 수를 마지막으로 하는 가장 긴 감소하는 부분 수열의 길이

초기값
-> 자기 자신만 선택해도 길이 1
=> dp[i] = 1

i보다 앞에 있는 j에 대해
arr[j] > arr[i] 이면 (감소)
dp[i] = max(dp[i], dp[j] + 1)

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 초기값
        }

        // DP
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 감소 조건
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
