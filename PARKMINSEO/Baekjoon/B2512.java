import java.io.*;
import java.util.*;

/**
 * 실버 2 이분 탐색
 * 시작점, 끝점을 기준으로 중간값을 잡아 탐색 범위를 줄여가며 값을 찾는 방식
 * 처음에는 시작점을 0, 끝점을 최대 요청 예산액으로 잡아서 점차 탐색 범위를 줄여나가는 식으로 풀이
 */

public class B2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int[] amounts = new int[n]; // 각 도시의 요청 예산액

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = -1; // 최대 요청 예산액
        for(int i = 0; i < n; i++){
            int amount = Integer.parseInt(st.nextToken());
            amounts[i] = amount;
            end = Math.max(end, amount);
        }

        int budget = Integer.parseInt(br.readLine()); // 정부가 지정한 총 예산액
        while(start <= end){
            int mid = (start + end) / 2; // 중간값
            int total = 0; // 배정 가능한 총 예산액
            for(int i = 0; i < n; i++){
                total += Math.min(mid, amounts[i]); // 중간값과 요청 예산액를 비교
            }

            if(total <= budget){ // 만약 총 합산액이 정부가 지정한 금액보다 작을 경우
                start = mid + 1; // 시작점을 중간값 + 1 값으로 이동
            }else{ // 만약 총 합산액이 정부가 지정한 금액보다 클 경우
               end = mid - 1; // 끝점을 중간값 -1 값으로 이동
            }
        }

        System.out.println(end);

    }
}