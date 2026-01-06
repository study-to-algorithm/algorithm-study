package KIMSEONGEUN.Baekjoon.dfsNbfs;

import java.util.*;
import java.io.*;

// 문제: 미로 탐색
public class B2178 {

    /*
     * 최단거리 = BFS
     *
     * 1) 최소 몇 번을 묻는 문제 ex) 촌수 계산, 미로 탐색, 최단 이동 횟수, 최소 간선 수
     * => 각 칸마다 시작점으로부터 몇 단계인지 필요
     * => dist 배열 사용
     *
     * 2) 몇 개를 묻는 문제 ex) 연결 요소, 덩어리, 컴포넌트 개수
     * => 덩어리 하나를 방문 처리하고 시작점 발견할 때마다 +1
     * => int count 사용
     */
    static int N, M; // 세로, 가로
    static int[][] map; // 좌표
    static boolean[][] visited; // 방문 배열
    static int[][] dist;// 지나야 하는 최소 칸 수

    // 상하좌우 탐색 방향 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
