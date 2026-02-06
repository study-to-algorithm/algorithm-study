import java.util.*;
import java.io.*;

/** 실버 5 구현
 * 매달에 따른 나라별 정렬을 마친 뒤 정렬순대로 순위를 매김
 */


public class B10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나라 개수
        int k = Integer.parseInt(st.nextToken()); // 찾고 싶은 나라의 번호

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 나라 번호
            arr[i][0] = num;
            for (int j = 1; j <= 3; j++) {
                int a = Integer.parseInt(st.nextToken()); // 메달의 개수
                arr[i][j] = a;
            }
        }

        Arrays.sort(arr, (a, b) -> { // 정렬
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });

        int rank = 1;
        for(int i = 0; i < n; i++){
            if(i > 0) {
                // 앞의 나라와 금,은,동의 개수가 모두 일치하지 않으면 등수 + 1
                if (arr[i][1] == arr[i - 1][1] && arr[i][2] == arr[i - 1][2] && arr[i][3] == arr[i - 1][3]) {
                    // rank 유지
                } else {
                    rank = i + 1;
                }
            }

            if(arr[i][0] == k){ // 찾는 나라라면
                System.out.println(rank);
                break;
            }
        }
    }
}