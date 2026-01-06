import java.util.*;
import java.io.*;
/*
 * 실버 4 큐
 * 원에서 사람들이 제거되는 순서 = 요세푸스 순열
 */

public class B2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("1 "); // 처음에는 무조건 1번 먼저
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int []> que = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(st.nextToken());
            que.add(new int[] {i, a}); // 인덱스, 이동할 값
        }

        int[] balloon = que.poll(); // 먼저 1번 풍선 제거
        while(!que.isEmpty()){
            if(balloon[1] > 0){ // 이동할 값이 양수이면
                for(int i = 1; i < balloon[1]; i++){
                    que.add(que.poll()); // 큐에서 제거한 후 다시 추가
                }
                balloon = que.poll(); // 제거될 풍선
                sb.append(balloon[0]).append(" ");
            }else { // 음수일 경우
                for(int i = 1; i < -balloon[1]; i++){ // 오른쪽에 있는 수부터 앞에 추가
                    que.addFirst(que.pollLast());
                }
                balloon = que.pollLast(); // 제거될 풍선
                sb.append(balloon[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}