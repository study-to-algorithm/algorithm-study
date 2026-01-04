import java.util.*;
import java.io.*;
/*
 * 실버 4 스택
 * 원에서 사람들이 제거되는 순서 = 요세푸스 순열

 */

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // 몇 번째 사람 제거될지

        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){ // 1부터 시작
            que.add(i); // 우선 큐에 1 ~ n까지 추가
        }

        int cnt = 1; // 큐에서 사람을 꺼낸 횟수 (순환 카운트)
        int removed = 0; // 제거된 개수
        while(!que.isEmpty()){
            int a = que.poll(); // 먼저 큐에서 제거한 후,
            if(cnt % k != 0){ // 제거 대상이 아닐 경우, 큐에 다시 추가
                que.add(a);
            }else{
                removed++;
                sb.append(a).append(removed == n ? ">" : ", ");
            }
            cnt++;
        }
        System.out.println(sb);
    }
}