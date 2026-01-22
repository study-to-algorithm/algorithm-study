import java.io.*;
import java.util.*;

/**
 * 실버 3 슬라이딩 윈도우 + 투 포인터
 * 연속된 x일의 방문자 수 합을 한 칸씩 이동하며 빼고 더하고를 반복하여 갱신
 */

public class B21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 블로그 시작하고 지난 일수
        int x = Integer.parseInt(st.nextToken()); // x일 동안 가장 많이 방문한 수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 1일 ~ n일까지 하루동안의 방문자 수
        }

        int sum = 0;
        for(int i = 0; i < x; i++){ // 첫 구간을 미리 합
            sum += arr[i];
        }

        int max = sum;
        int cnt = 1; // 최대 방문자 수가 나온 기간의 개수
        for(int i = 1; i <= n - x; i++){
            sum = sum - arr[i - 1] + arr[i + x - 1]; // 슬라이딩 윈도우
            if(max < sum){ // 기간 카운트
                max = sum;
                cnt = 1; // 초기화
            }else if(max == sum){
                cnt++;
            }
        }

        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }


    }
}