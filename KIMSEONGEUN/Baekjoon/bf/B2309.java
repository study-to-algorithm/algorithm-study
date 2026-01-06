package KIMSEONGEUN.Baekjoon.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제: 일곱난쟁이 (브론즈 1)
public class B2309 {

    /*
     * 완전 탐색?
     * 1) 주어지는 키는 100을 넘지 않는 자연수 => 범위 작음
     * 2) 가능한 정답이 여러 가지인 경우에는 아무거나 출력
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];

        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;

        for (int i : height) {
            total += i;
        }

        int fake1 = 0;
        int fake2 = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (height[i] + height[j] == total - 100) {
                    fake1 = height[i];
                    fake2 = height[j];
                    found = true;
                    break;
                }
            }
        }

        Arrays.sort(height);

        boolean skip1 = false;
        boolean skip2 = false;

        for (int i = 0; i < 9; i++) {
            if (height[i] == fake1 && !skip1) {
                skip1 = true;
                continue;
            }
            if (height[i] == fake2 && !skip2) {
                skip2 = true;
                continue;
            }

            System.out.println(height[i]);
        }
    }
}
