package KIMSEONGEUN.Baekjoon.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 숫자 야구 (실버 3)
public class B2503 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());

        int[][] ask = new int[time][3];

        for (int i = 0; i < time; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                ask[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 123; i <= 987; i++) {

          int a = i / 100; // 백의 자리
          int b = (i / 10) % 10; // 십의 자리
          int c = i % 10; // 일의 자리

          if (a == 0 || b == 0 || c == 0) continue;
          if (a == b || b == c || a == c) continue;


          boolean ok = true;

          for (int j = 0; j < time; j++) {
              int strike = 0;
              int ball = 0;

              int num = ask[j][0];
              int x1 = num / 100;
              int x2 = (num / 10) % 10;
              int x3 = num % 10;

              if (a == x1) strike++;
              if (b == x2) strike++;
              if (c == x3) strike++;

              if (a == x2 || a == x3) ball++;
              if (b == x1 || b == x3) ball++;
              if (c == x1 || c == x2) ball++;

              if (strike != ask[j][1] || ball != ask[j][2]) {
                  ok = false;
                  break;
              }

          }

          if (ok) answer++;
        }

        System.out.println(answer);
    }
}
