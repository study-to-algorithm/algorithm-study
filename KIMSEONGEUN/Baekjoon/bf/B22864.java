package KIMSEONGEUN.Baekjoon.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 피로도 (브론즈 2)
public class B22864 {

    /*
     * 완전 탐색? 가능한 경우의 수를 모두 조사해서 정답을 찾는 방법
     * 1) 1시간마다 => 상태 시뮬레이션
     * 2) 하루는 24시간 => 반복 횟수가 고정, 작음
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 쌓이는 피로도
        int B = Integer.parseInt(st.nextToken()); // 일 처리량
        int C = Integer.parseInt(st.nextToken()); // 줄어드는 피로도
        int M = Integer.parseInt(st.nextToken()); // 피로도 최대치 M

        // 현재 피로도
        int P = 0;

        // 작업량
        int work = 0;

        for (int i = 1; i <= 24; i++) {
            // 일할 수 있는 경우
            if (P + A <= M) {
                P += A;
                work += B;
            }
            // 일하지 못할 경우
            else {
                P -= C;
                if (P < 0) {
                    P = 0;
                }
            }
        }

        System.out.println(work);
    }
}
