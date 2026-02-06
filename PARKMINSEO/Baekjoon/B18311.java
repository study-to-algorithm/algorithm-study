import java.util.*;
import java.io.*;

/** 실버 5 구현
 */


public class B18311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 코스 개수
        long k = Long.parseLong(st.nextToken()); // 이동 거리

        long[] course = new long[n]; // 코스
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            course[i] = a;
        }

        boolean reverse = false;
        for(int i = 0; i < n; i++) {
            k -= course[i];
            if(k < 0) {
                System.out.println(i + 1);
                reverse = true;
                break;
            }
        }

        if(!reverse) {
            for(int i = n - 1; i >= 0; i--) {
                k -= course[i];
                if(k < 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}