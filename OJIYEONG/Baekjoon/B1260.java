/*
[DFS]
백준 1260번 DFS와 BFS
 */

import java.util.*;
import java.io.*;

public class Main {

    static int n; // 정점
    static int m; // 간선
    static int start; // 시작
    //    static int[][] graph; // 메모리 효율 떨어짐
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
//        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);

            Collections.sort(graph[a]);
            Collections.sort(graph[b]);

        }
        visited = new boolean[n+1];
        dfs(start);
        System.out.println();

        visited = new boolean[n+1]; // dfs 실행한 값 초기화
        bfs(start);
    }

    static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
//        for(int i = 0; i < graph[v].size(); i++){
//            if(!visited[i]){
//                dfs(graph[v].get(i));
//            }
//        }
        for (int next :  graph[v]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");

            for (int next :  graph[u]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

}
