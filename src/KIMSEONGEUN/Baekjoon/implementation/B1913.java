package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제: 달팽이 (실버 3)
public class B1913 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] snail = new int[n][n];
        StringBuilder sb = new StringBuilder();

        //  거꾸로 채우기
        int x = 0, y = 0, d = 0;
        int targetX = 0, targetY = 0;
        int temp = n * n;

        while (temp > 0) {
            snail[x][y] = temp;

            // 현재 숫자와 찾는 숫자가 같으면 좌표 저장
            if (num == temp) {
                targetX = x + 1;
                targetY = y + 1;
            }

            if (temp == 1) break;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
            temp--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);
        System.out.print(sb);
    }
}
