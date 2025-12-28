package KIMSEONGEUN.Baekjoon.dfs;

import java.io.*;
import java.util.*;

// 문제: 바닥 장식
public class B1388 {

    /**
     * 같은 판자(연결된 구역)가 몇 개인지 세는 문제
     * = 연결 요소 탐색 DFS
     */

    static int n, m; // n: 세로, m: 가로
    static char[][] arr; // 바닥 모양 저장 좌표
    static boolean[][] visited; // 방문 여부 배열
    static int count; // 판자 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 칸마다 좌표가 있기 때문에 인접 배열 생성 X
        // 연결 정보가 쌍(a, b) 형태로 주어지면 인접 리스트 생성
        arr = new char[n][m];
        visited = new boolean[n][m];

        // 바닥 문자열 입력: 한 줄을 char 배열로 바꿔서 그대로 넣기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        // 판자 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문하지 않은 칸이 있을 경우 = 새로운 판자의 시작점
                if (!visited[i][j]) {
                    count++; // 판자 추가
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        // 현재 칸 방문 처리
        visited[x][y] = true;

        if (arr[x][y] == '-') {
            int ny = y + 1; // 다음 열로 이동
            // 정의한 판자가 범위 안 + 미방문 + 같은 모양이면 계속 DFS
            if (ny < m && !visited[x][ny] && arr[x][ny] == '-') {
                dfs(x, ny);
            }
        }

        else {
            int nx = x + 1;
            if (nx < n && !visited[nx][y] && arr[nx][y] == '|') {
                dfs(nx, y);
            }
        }
    }
}
