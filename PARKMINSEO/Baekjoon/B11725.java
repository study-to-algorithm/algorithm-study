import java.util.*;
import java.io.*;
/**
 * 실버 2 dfs
 * n이 100,000까지이기 때문에 [][] 인접행렬을 사용하면 메모리 초과 발 -> 리스트로 구현
 */

public class B11725 {
    static int n; // 노드의 개수
    static List<Integer>[] arr; // 연결된 두 정점 저장
    static boolean[] visited; // 방문 여부 확인
    static int[] parent; // 부모 노드를 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1); // 1부터 탐색 시작

        for(int i = 2; i <= n; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
    private static void dfs(int start){
        visited[start] = true; // 방문 표시
        for(int next : arr[start]){
            if(!visited[next]){
                parent[next] = start;
                dfs(next);
            }
        }
    }
}