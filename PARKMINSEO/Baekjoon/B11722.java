import java.util.*;
import java.io.*;
/**
 * 실버 2 dp
 * 뒤로 갈수로 값이 작아지는 수열 중에서의 최대 수열 길이
 */

public class B11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1]; // 배열 선언
        int[] dp = new int[n + 1]; // dp 선언

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        for(int i = 1; i <= n; i++){
            dp[i] = 1; // 자기 자신 포함하기 때문에 1부터 시작
            for(int j = 1; j < i; j++){
                if(arr[i] < arr[j]){ // 감소하는 수열이니깐 앞의 숫자가 더 클 경우에만
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 현재 위치에 있는 값과 이전 값 + 현재 값을 비교해서 저장
                }
            }
        }

        int max = -1;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}