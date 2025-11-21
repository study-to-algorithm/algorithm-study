/*
[DFS]
백준 11724번 연결 요소의 개수
 */
import java.util.*;

public class Main {

    static int m; // 간선
    static int n; // 정점
    static boolean[] visited;
    static int[][] graph;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int i = 1; i <= n; i++){
            if (!visited[i]){
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    static void DFS(int v){
        visited[v] = true;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && graph[v][i] == 1){
                DFS(i);
            }
        }
    }

}