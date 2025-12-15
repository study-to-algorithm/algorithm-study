/*
[자료구조 + 문자열] => 해쉬맵 사용해서 풀어보고 싶어서 골랐음
백준 1302번 베스트셀러

빈도 계산하고, 최대값 찾기
최대값 여러개면 사전순으로 가장 앞선 제목
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>(); // 해쉬맵은 key, value 구조

        for (int i = 0; i < n; i++) {
            String bookName = br.readLine();
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
            // map.getOrDefault(key, 기본값) => key가 있으면 해당 값 반환, 없으면 기본값 반환
            // map.getOrDefault(bookName, 0) => bookName이 있으면 해당 값을 반환하고 없으면 0을 반환함
        }

        int max = 0;
        String answer = "";

        for (String key : map.keySet()) { // map.keySet() : map에 들어있는 모든 key 반환
            int cnt = map.get(key);

            if (cnt > max) {
                max = cnt;
                answer = key;
            } else if (cnt == max) {
                if (key.compareTo(answer) < 0) { // 사전순 비교했을 때 더 앞선 순서인 경우
                    answer = key;
                }
            }
        }

        System.out.println(answer);
    }


}