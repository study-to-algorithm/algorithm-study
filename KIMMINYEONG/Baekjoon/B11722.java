import java.io.*;
import java.util.*;

public class B11722{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N]; // dp[i] : i번째 수를 마지막으로 하는 가장 긴 감소 부분 수열 길이
        int result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken()); // 수열 입력받기
        }
        
        for(int i=0; i<N; i++){
            dp[i] = 1; // 부분 수열을 생각해보면 무조건 1개는 들어가므로 1은 넣어주기
            for(int j=0; j<i; j++){
                if(arr[i]<arr[j]){ // 이전 값이 더 크면 감소 수열
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}