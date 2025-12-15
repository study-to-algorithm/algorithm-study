import java.util.*;
import java.io.*;
/**
 문제 해결방법
 지렁이는 아래, 오른쪽만 이동 가능
 지정된 숫자로만 이동 가능 -> 숫자보다 적은 수나 많은 수로 이동 불가

 (아놔 split " "을 ""로 해가지고 지금 에러가 몇 개가 뜬거야;;)
 */

public class Main{
    static int n;
    static int[][] arr;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean success = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        n = Integer.parseInt(br.readLine()); // 정사각형 길이

        arr = new int[n][n]; // 배열 크기 초기화
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(str[j]); // 값 저장
            }
        }
        dfs(0, 0); // 시작 부분부터 시작
        if (success) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static void dfs(int i, int j) {
        if(success) return;
        if(arr[i][j] == -1){ // 도착지점에 입장하면 리턴
            success = true;
            return;
        }
        if (arr[i][j] == 0) return; // 0이면 이동 불가

        for(int k = 0; k < 2; k++){
            int x = i + dx[k] * arr[i][j];
            int y = j + dy[k] * arr[i][j];

            if(x >= 0 && x < n && y >= 0 && y < n){
                dfs(x, y);
            }
        }

    }

}