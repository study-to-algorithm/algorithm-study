package KIMSEONGEUN.Baekjoon.dfs;

import java.util.*;
import java.io.*;

// 문제: 바이러스 (실버3)
public class B2606 {

    /**
     * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수?
     * = 1번에서 시작해서 연결로 따라갈 수 있는 모든 노드를 전부 방문
     * = DFS (최단 거리, 최소 횟수와 같은 말이 없음)
     */


    static int com; // 컴퓨터 수 (노드)
    static int net; // 연결 수 (간선)
    static int count;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine());
        net = Integer.parseInt(br.readLine());

        // 방문 리스트 생성 (0번은 사용 X)
        visited = new boolean[com + 1];

        // 인접 리스트 배열 (0번은 사용 X)
        graph = new ArrayList[com + 1];

        // 각 칸에 리스트 생성
        for (int i = 1; i <= com ; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 0; i < net; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무방향 그래프 -> 양쪽 모두 추가
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;

        // x와 연결된 모든 컴퓨터 탐색
        for (int i = 0; i < graph[x].size(); i++) {
            int next = graph[x].get(i);

            // 아직 방문하지 않았으면
            if (!visited[next]) {
                count++; // 방문 개수 추가
                dfs(next);
            }
        }
    }
}
