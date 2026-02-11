import java.io.*;
import java.util.*;

/**
 * 실버 5 해시
 */

public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //연산의 수
        HashSet<Integer> hash = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            int x;

            switch(com){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    hash.add(x); // 굳이 contains 검사 필요 없음, 알아서 무시함
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    hash.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if(hash.contains(x)) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(!hash.contains(x)) hash.add(x);
                    else hash.remove(x);
                    break;
                case "all":
                    hash.clear();
                    for (int j = 1; j <= 20; j++) {
                        hash.add(j);
                    }
                    break;
                case "empty":
                    hash.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}