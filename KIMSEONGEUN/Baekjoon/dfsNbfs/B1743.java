package KIMSEONGEUN.Baekjoon.dfsNbfs;

import java.util.*;
import java.io.*;


// 문제: 음식물 피하기
public class B1743 {

    /*
     * 붙어있는 음식물 덩어리(연결요소)의 크기 세기
     * => BFS
     */

    static int N, M, K; // 세로, 가로, 개수
    static int[][] map; // 좌표 배열
    static boolean[][] visited; // 방문 배열

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 1;
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        int size = 1;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 탐색 기준 좌표
            int cx = cur[0];
            int cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                size++;
                q.add(new int[]{nx, ny});
            }

        }

        return size;
    }
}
