package KIMSEONGEUN.Baekjoon.dfs;

import java.io.*;
import java.util.*;

// 문제: 점프왕 쩰리
public class B16173 {

    /**
     * (0, 0)에서 시작해서 끝점까지의 도달 가능성
     * 최단거리/최소 이동 회수 요구 X => DFS
     */

    static int n; // 게임 구역 크기
    static int[][] arr; // 게임 구역 좌표
    static boolean[][] visited; // 방문 여부
    static boolean reach = false; // 도착 여부

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        // 좌표 채우기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
             arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, 0);


        if (reach) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void dfs(int x, int y) {
        // 이전에 방문했던 칸이면 다시 탐색할 필요 없음
        if (visited[x][y]) {
            return; // 이전 재귀로 돌아감
        }

        visited[x][y] = true;

        // 이동할 칸의 값
        int move = arr[x][y];

        // 도착점에 도달하면 성공
        if (move == -1) {
            reach = true;
            return;
        }

        // 아래로 이동
        int nx = x + move;
        if (nx < n) {
            dfs(nx, y);
        }

        // 오른쪽으로 이동
        int ny = y + move;
        if (ny < n) {
            dfs (x, ny);
        }
    }
}
