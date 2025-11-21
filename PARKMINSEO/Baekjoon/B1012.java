import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, k;
    static boolean[][] visited; // 재방문 여부
    static boolean[][] graph; // 연결관계
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // test case 수
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());// 배추밭 가로 길이
            n =Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            k = Integer.parseInt(st.nextToken());// 배추가 심어져 있는 위치의 개수

            visited = new boolean[n][m];
            graph = new boolean[n][m];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = true;
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j] && graph[i][j]) { // 방문된 적 없고 배추가 심어져 있는 경우
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int a, int b){
        visited[a][b] = true;
        for(int i = 0; i < 4; i++){
            int x = a + dx[i];
            int y = b + dy[i];
            if(x < 0 || y < 0 || x >= n || y >= m)
                continue;
            if(!visited[x][y] && graph[x][y]){
                bfs(x, y);
            }
        }
    }
}