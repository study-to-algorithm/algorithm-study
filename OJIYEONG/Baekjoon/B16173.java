/*
[DFS]
백준 16173번 점프왕 쩰리

 */
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
//    static boolean[][] visited; // 여러번 방문해도 상관 x, 안 써도 됨

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
//        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // br.readLine()이 한 줄만 읽어서 계속 초기화해줘야됨
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0) ? "HaruHaru" : "Hing");
    }

    static boolean dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) return true; // 도착

        if (x < 0 || x >= n || y < 0 || y >= n) return false; // 범위 넘어감

//        visited[x][y] = true;

        int jump = map[x][y]; // 지금 위치의 값
        if (jump == 0) return false; // 0이면 무한 제귀 호출 발생 -> 메모리 초과
        return dfs(x+jump, y) || dfs(x, y+jump);
    }

}
