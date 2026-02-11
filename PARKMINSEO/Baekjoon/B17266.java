import java.io.*;
import java.util.*;

/**
 * 실버 4 구현
 * 양끝과 가장 먼 가로등의 길이, 가로등과 가로등 사이 중 가장 먼 길이를 비교
 */

public class B17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int m = Integer.parseInt(br.readLine()); // 가로등의 개수

        boolean[] arr = new boolean[n + 1]; // 가로등의 위치
        int[] dis = new int[m + 1]; // 양끝, 가로등과의 거리 계산

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[a] = true; // 가로등이 있는 위치에 true
        }

        int cnt = 0;
        int last = 0;
        for(int i = 0; i <= n; i++){
            if(arr[i] || i == n){ // 마지막 끝과의 거리도 계산
                dis[cnt] = i - last;
                last = i;
                cnt++;
            }
        }

        for(int i = 1; i < cnt - 1; i++){ // 가로등들 간의 거리는 /2로
            dis[i] = (dis[i] + 1) / 2; // 올림해서 안전하게 거리 확보(?)
        }


        Arrays.sort(dis); // 오름차순 정렬

        System.out.println(dis[m]);




    }
}