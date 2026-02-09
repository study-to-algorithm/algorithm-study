package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 빙고 (실버 4)
public class B2578 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[][] bingo = new int[5][5];
        int[][] check = new int[5][5];
        int totalOrder = 0; // 사회자가 부른 숫자 순서
        int num = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                totalOrder++;
                int temp = Integer.parseInt(st.nextToken());

                // 번호 마킹
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[k][l] == temp) {
                            check[k][l] = 1;
                        }
                    }
                }

                // 빙고 개수 체크
                int count = 0;

                // 가로 체크
                for (int k = 0; k < 5; k++) {
                    int rowSum = 0;
                    for (int l = 0; l < 5; l++) {
                        if (check[k][l] == 1) rowSum++;
                    }
                    if (rowSum == 5) count++;
                }

                // 세로 체크
                for (int k = 0; k < 5; k++) {
                    int colSum = 0;
                    for (int l = 0; l < 5; l++) {
                        if (check[l][k] == 1) colSum++;
                    }
                    if (colSum == 5) count++;
                }

                // 대각선 체크 (\모양)
                int diaSum1 = 0;
                for (int k = 0; k < 5; k++) {
                    if (check[k][k] == 1) diaSum1++;
                }
                if (diaSum1 == 5) count++;

                // 대각선 체크 (/모양)
                int diaSum2 = 0;
                for (int k = 0; k < 5; k++) {
                    if (check[k][4 - k] == 1) diaSum2++;
                }
                if (diaSum2 == 5) count++;

                if (count >= 3) {
                    System.out.println(totalOrder);
                    return;
                }
            }
        }
    }
}
