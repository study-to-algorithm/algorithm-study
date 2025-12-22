/*
[완전탐색]
백준 2503번 숫자 야구

1) 가능한 모든 3자리 수(중복X, 0 포함X)를 전부 생성
2) 각 수에 대해서 모든 질문과 비교
3) strike / ball 개수가 하나라도 다르면 X
4) 모든 조건을 만족하면 정답 카운트++
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] question = new int[N];
        int[] strike = new int[N];
        int[] ball = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            question[i] = Integer.parseInt(st.nextToken());
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int num = 123; num <= 987; num++) {

            String candidate = String.valueOf(num);

            // 0 포함 or 중복 숫자 제거
            if (candidate.charAt(0) == '0' ||
                    candidate.charAt(1) == '0' ||
                    candidate.charAt(2) == '0') continue;

            if (candidate.charAt(0) == candidate.charAt(1) ||
                    candidate.charAt(0) == candidate.charAt(2) ||
                    candidate.charAt(1) == candidate.charAt(2)) continue;

            boolean possible = true;

            // 모든 질문과 비교
            for (int i = 0; i < N; i++) {
                String q = String.valueOf(question[i]);

                int s = 0;
                int b = 0;

                // strike
                for (int j = 0; j < 3; j++) {
                    if (candidate.charAt(j) == q.charAt(j)) {
                        s++;
                    }
                }

                // ball
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j != k && candidate.charAt(j) == q.charAt(k)) {
                            b++;
                        }
                    }
                }

                if (s != strike[i] || b != ball[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) answer++;
        }

        System.out.println(answer);
    }
}
