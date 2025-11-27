import java.util.*;
import java.io.*;
/**
 문제 해결방법
 | 이거인 경우 아래로 탐색
 \ 이거인 경우 옆으로 탐색
 */

public class Main{
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        n = Integer.parseInt(st.nextToken()); // 세로 길이
        m = Integer.parseInt(st.nextToken()); // 가로 길이

        arr = new char[n][m]; // 배열 크기 초기화
        visited = new boolean[n][m]; // 초기화
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j); // 값 저장
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue; // 이미 방문했다면 패스
                if(arr[i][j] == '-') dfs(i, j, true); // - 면 오른쪽으로 탐색
                else dfs(i, j, false); // | 면 아래로 탐색
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true; // 이제 방문했으니깐 true 로 변경
        if(row) { // 같은 줄에서 - 탐색
            j++;
            if(j < m && arr[i][j] == '-') dfs(i, j, true);
        }
        else { // 같은 열에서 | 탐색
            i++;
            if(i < n && arr[i][j] != '-') dfs(i, j, false);
        }

    }

}