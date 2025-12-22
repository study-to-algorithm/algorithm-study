/*
[완전탐색]
백준 15721번 번데기

특정 단어(0=뻔, 1=데기)가 T번째로 불릴 때 그 단어를 외친 사람 번호 구하기

N명이 원형으로 서서 순서대로 단어를 외침
- 사람 번호는 0부터 시작
- 단어는 규칙에 따라 반복됨

단어 규칙
1)
뻔, 데기
뻔, 데기   (처음에만 고정 2회)

2)
뻔 k번
데기 k번
(k = 2부터 시작, 한 사이클마다 +1)

-> 단어를 하나 외칠 때마다 num++
-> 찾는 단어면 count++

=> count == T가 되는 순간
   사람 번호 = num % N
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 인원 수
        int T = Integer.parseInt(br.readLine()); // 찾고자 하는 번째
        int target = Integer.parseInt(br.readLine()); // 0:번, 1:데기

        int bbeonCount = 0;
        int degiCount = 0;
        int round = 2; // n회차 (번/데기가 각각 n번씩 반복됨)

        while (true) {
            // 1. 앞선 4번의 기본 구호 (번 - 데기 - 번 - 데기)
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) bbeonCount++;
                else degiCount++;

                if (check(bbeonCount, degiCount, target, T, N)) return;
            }

            // 2. 뒤의 연속 구호 (번 * round, 데기 * round)
            // 번 반복
            for (int i = 0; i < round; i++) {
                bbeonCount++;
                if (check(bbeonCount, degiCount, target, T, N)) return;
            }
            // 데기 반복
            for (int i = 0; i < round; i++) {
                degiCount++;
                if (check(bbeonCount, degiCount, target, T, N)) return;
            }

            round++; // 다음 회차로
        }
    }


    public static boolean check(int bbeon, int degi, int target, int T, int N) {
        int currentCount = (target == 0) ? bbeon : degi;
        if (currentCount == T) {
            // 전체 외친 횟수 = bbeon + degi
            // 사람 번호는 0부터 시작하므로 (전체 횟수 - 1) % N
            System.out.println((bbeon + degi - 1) % N);
            return true;
        }
        return false;
    }
}

