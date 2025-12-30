/*
[완전탐색 / DFS]
백준 1759번 암호 만들기 (골드5)

C개의 알파벳 중 길이가 L인 암호 조합

- 모음(a, e, i, o, u) 최소 1개
- 자음 최소 2개
- 사전순 출력

1. 알파벳 정렬
2. DFS로 L개 선택
3. 조건 만족 -> 출력
*/

import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr;
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 글자 수
        C = Integer.parseInt(st.nextToken()); // 주어진 글자 수

        arr = new char[C];
        selected = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        // 한 글자씩 다 해보고 조건에 맞는 것만 고르기
        dfs(0, 0);

        System.out.print(sb.toString());
    }

    static void dfs(int start, int depth) {

        // 길이 L 됐을 때만
        if (depth == L) {
            int vowel = 0; // 모음
            int consonant = 0; // 자음

            for (char c : selected) {
                if (isVowel(c)) vowel++;
                else consonant++;
            }

            if (vowel >= 1 && consonant >= 2) {
                sb.append(selected).append("\n");
                // append(char[])는 배열 전체를 문자열처럼 처리해줌
                // String[]는 컴파일 에러. char[]만 가능
            }
            return;
        }


        for (int i = start; i < C; i++) {
            selected[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    // 모음이 1개 이상 있어야 하기 때문에 검사
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
