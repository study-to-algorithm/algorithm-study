/*
[DFS]
백준 2606번 바이러스
 */
import java.util.*;
import java.io.*;

public class Main {

    static int com;
    static int link;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        com = Integer.parseInt(br.readLine());
        link = Integer.parseInt(br.readLine());

        // 그냥 항상 +1로 만들고 for문도 1부터 시작하는게 나음
        // => 문제는 항상 1부터 시작함
        graph = new ArrayList[com+1];
        visited = new boolean[com+1];

        for (int i = 1; i <= com; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < link; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(cnt);

    }

    static void dfs(int u){
        visited[u] = true;

        for(int next: graph[u]){
            if(!visited[next]){
                cnt++;
                dfs(next);
            }
        }
    }

}
