package KIMSEONGEUN.Baekjoon.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 진우의 달 여행 (Small) (실버 3)
public class B17484 {

    static int N, M, ans;
    static int[][] map;
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE; // 지금까지 발견한 최소 비용

        // 0행의 모든 열에서 시작
        for (int start = 0; start < M; start++) {
            dfs(0, start, map[0][start], -1);
        }

        System.out.println(ans);
    }

    // 한 가지 경로를 끝까지 따라가면서 최소 비용 갱신
    // r: 현재 행, c: 현재 열, sum: 누전 연료 소비량, prevDir: 이전 이동 방향
    static void dfs(int r, int c, int sum, int prevDir) {
        if (sum >= ans) return; // 최소 비용보다 커지면 return

        // 마지막 행에 도착했을 경우
        if (r == N - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        // 다음 방향 탐색 (이동 가능한 방향 3개)
        for (int dir = 0; dir < 3; dir++) {
            if (dir == prevDir) continue; // 같은 방향을 연속으로 사용할 수 없음
            int nr = r + 1; // 행은 무조건 아래로
            int nc = c + dc[dir]; // 열은 방향에 따라서

            if (nc < 0 || nc >= M) continue; // map을 벗어나는 경우

            dfs(nr, nc, sum + map[nr][nc], dir); // 위치 이동, 비용 누적, 이번에 쓴 방향을 prevDir로 넘김
        }
    }
}
