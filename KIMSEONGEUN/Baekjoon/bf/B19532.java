package KIMSEONGEUN.Baekjoon.bf;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 수학은 비대면 강의입니다 (브론즈 2)
public class B19532 {

    /*
     * 왜 완전탐색 문제인가?
     * 1) 정답 범위가 작음 => -999 이상 999 이하의 정수
     * 2) 정수 해를 찾아라 => 조건 만족하는 조합 찾기
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999 ; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
