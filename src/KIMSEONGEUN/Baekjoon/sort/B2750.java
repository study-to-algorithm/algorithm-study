package KIMSEONGEUN.Baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 수 정렬하기 (브론즈 2)
public class B2750 {

    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
