import java.io.*;
import java.util.*;

/**
 * 실버 1 bfs
 */

public class B9342 {
    static boolean[] visited; // 방문 여부
    static List<Integer>[] lists; // 컴퓨터들 간의 신뢰 여부
    static int n, m;
    static int[] cnt; // 해킹 가능한 컴퓨터의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 컴퓨터 1 ~ n 까지의 번호
        m = Integer.parseInt(st.nextToken());

        cnt = new int[n + 1];

        lists = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            lists[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = -1;
        for(int i = 1; i <= n; i++){ // 해킹 가능 최대값 찾기
            max = cnt[i] > max ? cnt[i] : max;
        }

        for(int i = 1; i <= n; i++){
            if(max == cnt[i]){
                System.out.print(i + " ");
            }
        }
    }
    static void bfs(int start){
        visited[start] = true;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        cnt[start] = 1; // 자기 자신도 포함

        while(!que.isEmpty()){
            int now = que.poll();
            for(int i : lists[now]){
                if (visited[i]) continue;
                cnt[start]++;
                visited[i] = true;
                que.add(i);
            }
        }
    }
}