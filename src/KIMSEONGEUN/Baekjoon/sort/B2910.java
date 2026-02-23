package KIMSEONGEUN.Baekjoon.sort;

import java.util.*;
import java.io.*;

// 문제: 빈도 정렬 (실버 3)
public class B2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> freq = new HashMap<>(); // 빈도
        Map<Integer, Integer> order = new HashMap<>(); // 최초 저장

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            // freq가 존재하면 기존 값 + 1, 없으면 기본값 0으로 추가
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

            if (!order.containsKey(arr[i]))
                order.put(arr[i], i);
        }

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {

            if (!freq.get(a).equals(freq.get(b)))
                return freq.get(b) - freq.get(a);

            return order.get(a) - order.get(b);
        });

        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
