import java.util.*;
import java.io.*;
/*
* 문제 해결 방법
방문할 정점의 개수가 여러 개일 경우, 작은 수부터 탐색
간선은 양방향

*/

public class Main{
    static int n, m, v;
    static int[][] arr;
    static boolean[] visited1;
    static boolean[] visited2;
    static Queue<Integer> que = new LinkedList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        arr = new int[n + 1][n + 1]; // 초기화
        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        dfs(v); // dfs 탐색 시작
        sb.append("\n");
        bfs(v);
        System.out.println(sb.toString());
    }
    private static void dfs(int start){
        visited1[start] = true; // 방문 표시
        sb.append(start + " "); // 먼저 출력에 추가
        for(int i = 0 ; i <= n; i++) {
            if(arr[start][i] == 1 && !visited1[i]) // 연결되어 있고 아직 방문 전이라면 dfs
                dfs(i);
        }
    }
    private static void bfs(int start){
        que.add(start); // 먼저 큐에 추가
        visited2[start] = true; // 방문 표시
        while(!que.isEmpty()){
            start = que.poll(); // 큐에서 빼내기
            sb.append(start + " ");
            for(int i = 1 ; i <= n; i++) {
                if(arr[start][i] == 1 && !visited2[i]) { // 연결되어 있고 아직 방문 전이라면
                    que.add(i); // 큐에 추가
                    visited2[i] = true; // 방문 표시
                }
            }
        }
    }
}