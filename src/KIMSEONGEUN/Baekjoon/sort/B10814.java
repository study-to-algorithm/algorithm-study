package KIMSEONGEUN.Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 문제: 나이순 정렬 (실버 5)
public class B10814 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (a, b) ->
                Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]))
        );

        StringBuilder sb = new StringBuilder();

        for (String[] s : arr) {
            sb.append(s[0]).append(" ").append(s[1]).append("\n");
        }

        System.out.println(sb);
    }
}
