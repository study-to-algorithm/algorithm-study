package KIMSEONGEUN.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11508 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3 3 2 / 2 => 6 + 2 = 8
        // 6 5 5 / 5 5 4 => 11 + 10 = 21

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;

        // 3번째 인덱스는 합계에서 제외
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 != 2) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }
}
