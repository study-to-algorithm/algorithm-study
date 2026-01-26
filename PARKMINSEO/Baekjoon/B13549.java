import java.io.*;
import java.util.*;

/**
 * 골드 5 bfs
 * 걷기 : 1초에 1씩 이동 가능, 순간이동 : 0초에 2배 이동 가능
 * 일반적인 bfs처럼 도착점에 도달한다고 끝내는 게 아니라 최소값을 찾아야 하기 때문에 모든 경우를 탐색
 * 최소값을 찾기 위해서는 일단 순간이동을 우선순위로 탐색
 */

public class B13549 {
    static int max = 100000;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[max + 1];
        Queue<int[]> que = new ArrayDeque<>(); // 현재 위치, 소요된 시간
        que.add(new int[] {n, 0}); // 첫 시작은 수빈이의 위치, 0초

        while(!que.isEmpty()){
            int[] a = que.poll();

            if(a[0] == k){
                answer = Math.min(answer, a[1]);
            }

            if(a[0] * 2 <= max && !visited[a[0] * 2]){ // 순간이동의 경우
                que.add(new int[] {a[0] * 2, a[1]});
                visited[a[0] * 2] = true;
            }
            if(a[0] + 1 <= max && !visited[a[0] + 1]){ // + 1할 경우
                que.add(new int[] {a[0] + 1, a[1] + 1});
                visited[a[0] + 1] = true;
            }
            if(a[0] - 1 >= 0 && !visited[a[0] - 1]){ // -1 할 경우
                que.add(new int[] {a[0] - 1, a[1] + 1});
                visited[a[0] - 1] = true;
            }
        }
        System.out.println(answer);
    }
}