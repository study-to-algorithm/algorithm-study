/*
[이분 탐색]
백준 2805번 나무 자르기

- 절단기 높이를 기준으로 탐색
- 잘린 나무 길이의 합이 M 이상인지 판단
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long left = 0;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    sum += (tree[i] - mid);
                }
            }

            if (sum >= M) {
                answer = mid;      // 가능한 높이
                left = mid + 1;    // 더 높게
            } else {
                right = mid - 1;   // 낮게
            }
        }

        System.out.println(answer);
    }
}
