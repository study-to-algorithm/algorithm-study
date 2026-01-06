package KIMSEONGEUN.Baekjoon.dfsNbfs;

import java.util.*;
import java.io.*;

// 문제: DFS와 BFS
public class B1260 {

    static int node, net, start;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        net = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < net; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);
        System.out.println();

        visited = new boolean[node + 1];
        bfs(start);

    }

    static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");

        for (int i = 0; i < graph[x].size(); i++) {
            int next = graph[x].get(i);
            if (!visited[next]) dfs(next);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>(); // 큐 선언
        visited[x] = true;

        q.add(x);

        while (!q.isEmpty()) { // 큐가 빌 때까지 계속 탐색
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
