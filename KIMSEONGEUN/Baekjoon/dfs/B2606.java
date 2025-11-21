package KIMSEONGEUN.Baekjoon.dfs;

import java.util.*;
import java.io.*;

public class B2606 {

    static int com;
    static int net;
    static int count;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine());
        net = Integer.parseInt(br.readLine());

        // 인접 배열 생성 - index 0번은 사용 안함
        graph = new ArrayList[com + 1];

        // 방문 배열 생성
        visited = new boolean[com + 1];

        // 인접 배열 안에 리스트 생성
        for (int i = 1; i <= com; i++) {
            graph[i] = new ArrayList<>();
        }

        // 리스트 간선 노드 연결
        for (int i = 0; i < net; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번째 컴퓨터부터 시작
        dfs(1);

        for (int i = 2; i <= com; i++) {
            if (visited[i]) count++;
        }

        System.out.println(count);
    }

    static void dfs(int x) {
        if (visited[x]) return;
        visited[x] = true;
        for (int i = 0; i < graph[x].size(); i++) {
            int next = graph[x].get(i);
            dfs(next);
        }
    }
}
