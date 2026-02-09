package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제: 별찍기 - 19 (실버 4)
public class B10994 {
    static char[][] starMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 크기 계산
        int size = 4 * (n - 1) + 1;
        starMap = new char[size][size];

        for (int i = 0; i < size; i++) {
            // 배열을 공백으로 초기화
            Arrays.fill(starMap[i], ' ');
        }

        drawStar(n, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(starMap[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawStar(int n, int x, int y) {
        if (n == 0) return; // 종료

        int len = 4 * (n - 1) + 1;

        // 테두리
        for (int i = 0; i < len; i++) {
            starMap[x][y + i] = '*';
            starMap[x + len - 1][y + i] = '*';

            starMap[x + i][y] = '*';
            starMap[x + i][y + len - 1] = '*';
        }

        drawStar(n - 1, x + 2, y + 2);
    }
}
