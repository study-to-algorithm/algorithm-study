import java.util.*;
import java.io.*;
/*
 * 실버 4 큐
 */

public class B10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push":
                    que.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");
                    break;
                case "empty":
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "front":
                    sb.append(que.isEmpty() ? -1 :que.getFirst()).append("\n");
                    break;
                case "back":
                    sb.append(que.isEmpty() ? -1 :que.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}