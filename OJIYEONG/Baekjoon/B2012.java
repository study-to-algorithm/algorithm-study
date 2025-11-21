/*
[BFS]
백준 1012번 유기농 배추
 */

import java.util.*;

public class Main {

    static int m; // 가로
    static int n; // 세로
    static int k; // 배추 수
    static int cnt; // 지렁이 수(answer)
    static int[][] map; // 밭
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스

        for (int e = 0; e < t; e++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            // 원래는 2차원 배열 만들 때 [세로][가로]가 맞음
            map = new int[m][n];
            visited = new boolean[m][n];

            cnt = 0;

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1; // 배추 위치 표시
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == 1) { // 배추 기준 주변 탐색
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] u = q.poll();
            int cx = u[0];
            int cy = u[1];

            for (int i = 0; i < 4; i++) { // 상하좌우 4번
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) { // 방문 안 했는데 배추가 있는 경우
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }

            }

        }

    }

}
