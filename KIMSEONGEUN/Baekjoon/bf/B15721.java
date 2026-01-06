package KIMSEONGEUN.Baekjoon.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제: 번데기 (실버 5)
public class B15721 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine()); // 게임을 진행하는 사람
        int T = Integer.parseInt(br.readLine()); // 구하고자 하는 번째
        int X = Integer.parseInt(br.readLine()); // 구하고자 하는 부호 (0이면 "뻔", 1이면 "데기")
        int count = 0; // 전체 외친 횟수
        int hit = 0; // X가 나온 횟수
        int round = 1;


        while (true) {

            // 고정 패턴
            int[] fixed = {0, 1, 0, 1};
            for (int s : fixed) {
                count++;
                if (s == X) hit++;
                if (hit == T) {
                    System.out.println((count - 1) % A);
                    return;
                }
            }

            // "뻔"을 round + 1번
            for (int i = 0; i < round + 1; i++) {
                count++;
                if (0 == X) hit++;
                if (hit == T) {
                    System.out.println((count - 1) % A);
                    return;
                }
            }

            // "데기"를 round + 1번
            for (int i = 0; i < round + 1; i++) {
                count++;
                if (1 == X) hit++;
                if (hit == T) {
                    System.out.println((count - 1) % A);
                    return;
                }
            }

            round++;
        }

    }
}
