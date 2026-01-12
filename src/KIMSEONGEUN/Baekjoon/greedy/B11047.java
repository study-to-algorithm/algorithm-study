package KIMSEONGEUN.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = 0;

        int arr[] = new int[num];

        // 동전 오름차순으로 주어짐
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 합계 % 동전 액수 계속 나누기?
            // for문 안에서 뒤에서부터 money와 배열 값 비교
            for (int i = arr.length - 1; i >= 0; i--) {
                // money >= 배열값이면
                if (money >= arr[i]) {
                    // 몫은 count +=
                    count += money / arr[i];
                    // money = 나누고 나머지
                    money %= arr[i];
                }
        }

        System.out.println(count);
    }
}
