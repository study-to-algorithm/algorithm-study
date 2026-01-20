import java.io.*;
import java.util.*;

/**
 * 실버 3
 * 도시로 넘어갈 때마다 주유 가격을 비교하는 방법
 * 서브태스크 100점 맞을려면 자료형을 int -> long으로 변경해줘야 함
 */

public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[n - 1]; // 각 도시 사이의 거리 ex) a--2--b--3--c => [2, 3]
        for(int i = 0; i < n - 1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] cost = new long[n]; // 각 도시의 주유 가격
        for(int i = 0; i < n; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long min = cost[0]; // 처음에는 0번째가 가장 싼 주유 가격
        long total = 0L;
        for(int i = 0; i < n - 1; i++){
            min = Math.min(min, cost[i]); // 가격 비교
            total += min * distance[i];
        }
        System.out.println(total);
    }
}
