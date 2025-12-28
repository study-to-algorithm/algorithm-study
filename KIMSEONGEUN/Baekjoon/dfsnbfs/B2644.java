package KIMSEONGEUN.Baekjoon.dfsnbfs;

import java.util.*;
import java.io.*;

// 문제: 촌수 계산 (실버 2)
public class B2644 {

    /**
     * 촌수 계산 = 몇 번 연결을 거치는가
     * = 최단거리 = BFS
     */

    static int node; // 사람 수 (노드 수)
    static int start, end; // 촌수를 계산해야 하는 사람 번호
    static int net; // 관계 수 (간선 수)
    static ArrayList<Integer>[] graph;
    static boolean[] visited; // 방문 배열
    static int[] result; // 촌수 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        net = Integer.parseInt(br.readLine());

        graph = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        result = new int[node + 1];

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

        bfs(start, end);

        if (visited[end]) {
            System.out.println(result[end]);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();

        visited[x] = true;
        result[x] = 0;
        q.add(x);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 목표 도달 시 종료 (최단거리 보장)
            if (cur == y) return;

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    // cur에서 다음 노드로 이동했다면 + 1
                    result[next] = result[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
