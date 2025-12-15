/*
[BFS]
백준 1697번 숨바꼭질

실버 1
 */

import java.io.*;
import java.util.*;

public class Main {
    static final int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈
        int k = Integer.parseInt(st.nextToken()); // 동생

        System.out.println(bfs(n, k));
    }

    static int bfs(int start, int target) {
        boolean[] visited = new boolean[max + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0}); // 현재 위치, 이동 횟수
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int dist = cur[1];

            if (pos == target) return dist;

            // 걷거나 순간이동
            int[] nextPos = {pos - 1, pos + 1, pos * 2};

            for (int np : nextPos) {
                if (np >= 0 && np <= max && !visited[np]) {
                    visited[np] = true;
                    q.offer(new int[]{np, dist + 1});
                }
            }
        }
        return -1; // 도달 못하면
    }
}
