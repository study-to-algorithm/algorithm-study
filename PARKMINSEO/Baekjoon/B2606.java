import java.util.*;
import java.io.*;
/*
* 문제 해결 방법
우선 dfs 돌린 다음 visited에서 참인 경우를 카운트하면 감염된 컴퓨터의 개수 알 수 있다
*/

public class Main{
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터의 개수
        m = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 개수

        arr = new int[n + 1][n + 1]; // 초기화
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        dfs(1); // dfs 탐색 시작
        int cnt = 0; // 탐색된 개수 세기
        for(int i = 2; i <= n; i++){ // 1번 컴퓨터는 카운트에 포함 안됨
            if(visited[i])
                cnt++;
        }
        System.out.println(cnt);
    }
    private static void dfs(int start){
        visited[start] = true; // 방문 표시
        for(int i = 0; i <= n; i++){
            if(arr[start][i] == 1 && !visited[i]){ // 연결되어 있고 아직 방문 전이라면 dfs
                dfs(i);
            }
        }
    }
}