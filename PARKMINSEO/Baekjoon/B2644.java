import java.util.*;
import java.io.*;

public class Main{
    static int n, m, a, b;
    static boolean[] visited; // 재방문 여부
    static boolean[][] graph; // 연결관계
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 전체 사람 수

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 1
        b = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 2

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 부모 자식 관계 수

        graph = new boolean[n+1][n+1]; // 배열 초기화
        visited = new boolean[n+1]; // 배열 초기화

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 부모
            int y = Integer.parseInt(st.nextToken()); // 자식
            graph[x][y] = graph[y][x] = true; // 연결 관계 저장
        }
        System.out.println(bfs(a));
    }
    static int bfs(int a){
        Queue<int[]> que = new LinkedList<>(); // {사람번호, }
        visited[a] = true;
        que.add(new int[]{a, 0}); // 계산 대상 1을 먼저 큐에 저장
        while(!que.isEmpty()){
            int[] tmp = que.poll(); // 큐에 저장된 데이터를 poll
            int node = tmp[0];
            int dist = tmp[1];
            if(node == b) // 만약 꺼낸 데이터가 계산 대상2와 같다면 ㅊㅗㄴㅅㅜㅂㅏㄴㅎㅗㅏㄴ
                return dist;
            for(int i = 1; i <= n; i++){ // 너비 우선이니 먼저 tmp와 연결된 데이터들을 큐에 적재, for문을 빠져나가서 tmp를 통해 너비 탐색
                if(visited[i] == false && graph[node][i]){
                    visited[i] = true;
                    que.add(new int[]{i, dist + 1});
                }
            }

        }
        return -1;
    }
}