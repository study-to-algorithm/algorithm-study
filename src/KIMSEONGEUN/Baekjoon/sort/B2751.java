package KIMSEONGEUN.Baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 수 정렬하기 2 (실버 5)
public class B2751 {

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

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
