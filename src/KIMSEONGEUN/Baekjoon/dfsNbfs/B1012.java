package KIMSEONGEUN.Baekjoon.dfsNbfs;

import java.util.*;
import java.io.*;

// 문제: 유기농 배추
public class B1012 {

    /*
     * 배추들의 연결 요소 개수 = 필요한 지렁이 최소 마리 수
     * => BFS 사용
     */

    static int T; // 테스트 케이스 개수
    static int M, N, K; // 가로, 세로, 배추 개수
    static int[][] map; // 땅 좌표
    static boolean[][] visited; // 방문 배열

    // 상하좌우 탐색 => 방향 배열 선언
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int count = 0;

            // 좌표 탐색해서 값이 1이고 방문하지 않은 좌표를 기준으로 bfs
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 기준 설정
            int cx = cur[0];
            int cy = cur[1];

            // 상하좌우 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                // 기준 벗어나는 경우 for문으로 돌아가 다른 상하좌우 탐색
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
