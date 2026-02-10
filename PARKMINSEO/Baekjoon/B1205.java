import java.io.*;
import java.util.*;

/**
 * 실버 4 구현
 */

public class B1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 점수 개수
        int score = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int p = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라 갈 수 있는 점수의 개수

        if(n == 0) { // 기존 점수가 없는 경우에는 아래 코드 실행시 널포인터 발생
            System.out.println(1);
            return;
        }

        int[][] arr = new int[n + 1][2];
        arr[0][0] = score;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]); // 내림차순 정렬

        arr[0][1] = 1; // 1등 임의 선정
        for(int i = 1; i <= n; i++){ // 순위 매기기
            if(arr[i][0] == arr[i - 1][0]){
                arr[i][1] = arr[i - 1][1];
            }else arr[i][1] = i + 1;
        }

        int cnt = -1;
        for(int i = 0; i <= n; i++){
            if(arr[i][0] == score) { // 태수의 새로운 점수일 경우
                cnt = i;
            }
        }

        if(cnt > (p - 1)) System.out.println(-1);
        else System.out.println(arr[cnt][1]);

    }
}