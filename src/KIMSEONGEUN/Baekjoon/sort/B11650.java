package KIMSEONGEUN.Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 문제: 좌표 정렬하기 (실버 5)
public class B11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
           if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
           return Integer.compare(a[1], b[1]);
        });

        StringBuilder sb = new StringBuilder();

        for (int[] i : arr) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }

        System.out.println(sb);
    }
}
