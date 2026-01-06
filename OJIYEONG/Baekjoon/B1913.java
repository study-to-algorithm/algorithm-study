/*
[구현(시뮬레이션)]
백준 1913번 달팽이

가운데에서 시작
1 -> N^2
위 -> 오른쪽 -> 아래 -> 왼쪽
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        // 위, 오른쪽, 아래, 왼쪽
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = N / 2;
        int y = N / 2;

        int num = 1;
        map[x][y] = num;

        int targetX = x, targetY = y;

        int len = 1;
        int dir = 0;

        while (num < N * N) {

            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < len; i++) {

                    if (num == N * N) break; // 런타임 에러X

                    x += dx[dir];
                    y += dy[dir];
                    num++;

                    map[x][y] = num;

                    if (num == M) {
                        targetX = x;
                        targetY = y;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(targetX + 1).append(" ").append(targetY + 1);
        System.out.println(sb);
    }
}
