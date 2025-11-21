package KIMSEONGEUN.Baekjoon.dfs;

import java.io.*;
import java.util.*;

public class B16173 {

    static int n; // 칸의 개수
    static int[][] arr; // 게임판
    static boolean[][] visited; // 도착 여부 배열
    static boolean reach = false; // 도착 여부

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        // 값 배열에 담기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (0, 0) 시작
        dfs(0, 0);

        // 도착했을 경우
        if (reach) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }

    }

    // dfs 함수
    static void dfs(int x, int y) {
        // 만약 방문했던 칸일 경우
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        // 이동할 칸
        int move = arr[x][y];

        if (move == -1) {
            reach = true;
            return;
        }

        // 오른쪽으로 이동
        int nextY = y + move;
        if (nextY < n) {
            dfs(x, nextY);
        }

        // 아래로 이동
        int nextX = x + move;
            if (nextX < n) {
                dfs(nextX, y);
            }
        }
}
