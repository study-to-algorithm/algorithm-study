package KIMSEONGEUN.Baekjoon.sort;

import java.io.*;
import java.util.*;

// 문제: 시리얼 번호 (실버 3)
public class B1431 {

    public static void main(String[] args) throws IOException {

        // 1. A와 B의 길이가 다르면 짧은 것이 먼저
        // 2. 서로 길이가 같다면 A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저
        // 3. 둘 다 아니라면 사전순으로 비교, 숫자가 알파벳보다 사전순으로 작은 것부터

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            // 1. 길이 비교
            if (a.length() != b.length())
                return a.length() - b.length();

            // 2. 숫자 합 비교
            int sumA = 0;
            int sumB = 0;

            for (char c : a.toCharArray()) {
                if (Character.isDigit(c)) sumA += c - '0';
            }

            for (char c : b.toCharArray()) {
                if (Character.isDigit(c)) sumB += c - '0';
            }

            if (sumA != sumB)
                return Integer.compare(sumA, sumB);

            // 3. 사전순
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
