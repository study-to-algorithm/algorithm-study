/*
[BFS]
백준 2644번 촌수계산
참고 : https://agi1004.tistory.com/50
 */

import java.util.*;

public class Main {

    static int[] degree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt(); // 총 사람 수
        int a =  sc.nextInt(); // 계산할 사람 1
        int b = sc.nextInt(); // 계산할 사람 2
        int m = sc.nextInt(); // 부모 자식들 간의 관계의 개수

        visited = new boolean[n+1];
        degree = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(degree, -1);

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt(); // 부모
            int y = sc.nextInt(); // 자식
            graph[x].add(y);
            graph[y].add(x);
        }


        bfs(a, graph); // 기준: 첫번째 사람

        System.out.println(degree[b]); // 첫번째 사람을 기준으로 두번째 사람의 차수(촌수)

    }

    static void bfs(int a, ArrayList<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a); // add보다 안정성이 좋음(예외가 아닌 false 반환)
        visited[a] = true;
        degree[a]++;

        while (!q.isEmpty()) {
            int u = q.poll(); // 현재 사람 꺼냄(기준으로 인접 체크)

            for (int next : graph[u]) { // x: u, next: y 라고 생각하면 됨
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    degree[next] = degree[u] + 1;
                }
            }
        }
    }
}
