package KIMSEONGEUN.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int sum = 0;
        int temp = 0;

        // 숫자 - (숫자 + 숫자)
        // ex) 10-20+30-40+50
        String[] arr = str.split("-");

        // 그 안에서 + 기준으로 split
        // + 기준으로 split한 배열 안 숫자 계산
        for (int i = 0; i < arr.length; i++) {

            // "-" 기준으로 split 10 | 20+30 | 40+50
            temp = 0;

            String[] split = arr[i].split("\\+");

            // "+" 기준으로 split
            for (int j = 0; j < split.length; j++) {
                temp += Integer.parseInt(split[j]);
            }

            if (i == 0) { // 10
                sum += temp;
            } else { // - 50 - 90
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
