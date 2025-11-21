package KIMSEONGEUN.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14916 {

    public static void main(String[] args) throws IOException {

        // 거스름돈 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 선언
        int change = Integer.parseInt(st.nextToken());
        int count = 0; // 동전 사용 개수

        // 1. 해 선택
            // 5원짜리 사용
        // 2. 적절성 검사
        while (true) {
            // 5원짜리 사용해서 change == 0이 되면 최적의 값
            if (change % 5 == 0) {
                count += (change / 5);
                System.out.println(count);
                return;
            }

            // 만약 그렇지 않으면 -2를 해보고 다시 5 사용 판단
            change -= 2;
            count++;

            // change == 0 만들 수 없으면 -1 반환
            if (change < 0) {
                System.out.println(-1);
                return;
            }
        }
    }
}
