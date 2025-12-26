import java.util.*;
import java.io.*;
/*
 * 실버 4 queue
 * 명령어의 개수가 최대 2,000,000이기 때문에
 * 일반 출력문 system.out.println을 계속 사용하면 시간 초과 뜸
 *     -> stringbuilder 사용
 */

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new ArrayDeque<>();
        int t = Integer.parseInt(br.readLine()); // 명령 개수
        int last = 0; // 마지막에 넣은 값을 알기 위한 값
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    que.add(a);
                    last = a;
                    break;
                case "pop":
                    sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(que.isEmpty() ? -1 : que.peek()).append("\n");
                    break;
                case "back":
                    sb.append(que.isEmpty() ? -1 : last).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}