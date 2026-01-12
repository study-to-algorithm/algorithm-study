/*
[이분 탐색]
백준 1654번 랜선 자르기

- 길이를 기준으로 탐색
- 어떤 길이(mid)로 잘랐을 때 만들 수 있는 랜선 개수가 N 이상인지 확인

이분 탐색
- left = 1
- right = 가장 긴 랜선 길이


- sum(랜선[i] / mid) >= N
  -> 길이를 늘릴 수 O (left 증가)
- sum < N
  -> 길이 너무 김 (right 감소)

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 기존 랜선
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선

        int[] arr = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long answer = 0;

        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }


            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
