/*
[DFS]
백준 1388번 바닥 장식

방문 X 칸? -> DFS
위아래 탐색 필요X, - 는 가로만 / |는 세로만
 */
import java.util.*;
import java.io.*;

public class Main {

    static int n; // 세로
    static int m; // 가로
    static char[][] ground;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // br.readLine() -> 한 줄 읽음
        String[] nm = br.readLine().split(" "); // 한 줄 읽어서 공백 기준으로 나눔
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        ground = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            ground[i] =  br.readLine().toCharArray();
        }

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        if (ground[x][y] == '-') {
            int ny = y+1;
//            if(!visited[x][ny] && ground[x][ny] == '-' && ny < m){
            if(ny < m && !visited[x][ny] && ground[x][ny] == '-'){
                // 범위 검사를 먼저 안 하면 ArrayIndexOutOfBoundsException 발생
                // !visited[x][ny] && ground[x][ny]를 먼저해서 ny가 m 보다 큰 경우(없음)이 발생함
                dfs(x, ny);
            }
        }

        if (ground[x][y] == '|') {
            int nx = x+1;
//            if (!visited[nx][y] && ground[nx][y] == '|' && nx < n) {
            if (nx < n && !visited[nx][y] && ground[nx][y] == '|') {
                dfs(nx, y);
            }
        }
    }

}
