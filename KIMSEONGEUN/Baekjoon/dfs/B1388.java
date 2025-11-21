package KIMSEONGEUN.Baekjoon.dfs;

import java.io.*;
import java.util.*;

public class B1388 {

    static int n, m;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    // return 했을 경우 count++;
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        // 방문 배열 true
        visited[x][y] = true;
        // 가로 판자 확인 -> 재귀함수로 다음 열 판자 검사
        if (arr[x][y] == '-') {
            int nextY = y + 1;
            // if 문 만족하지 못했을 경우 재귀함수 호출하지 않고 return
            if (nextY < m && !visited[x][nextY] && arr[x][nextY] == '-') {
                dfs(x, nextY);
            }
        }

        // 세로 판자 확인 -> 재귀함수로 다음 행 판자 검사
        else if (arr[x][y] == '|') {
            int nextX = x + 1;
            // if 문 만족하지 못했을 경우 재귀함수 호출하지 않고 return
            if (nextX < n && !visited[nextX][y] && arr[nextX][y] == '|') {
                dfs(nextX, y);
            }
        }
    }
}
