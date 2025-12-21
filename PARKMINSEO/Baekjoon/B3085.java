import java.util.*;
import java.io.*;
/*
 * 실버 2 브루트 푸스
 * 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
 * 서로 다른 색의 인접한 두 칸을 골라 사탕을 서로 교환한다고 했을 때, 같은 색으로 연속된 가장 긴 사탕의 개수
 * 인접하지만 색상이 다를 경우마다 계속 사탕 스왑하고 최대값 구하고 다시 원상복귀하고 이거를 반복해서 최대값을 구하면 된다.
 */

public class B3085{
    static char[][] arr;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // n X n 보드의 크기
        arr = new char [n][n]; // 배열 초기화
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                char c = s.charAt(j);
                arr[i][j] = c; // 배열 값 저장
            }
        }

        int answer = sameColor();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (j + 1 < n && arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j + 1); // 오른쪽과 교환
                    answer = Math.max(answer, sameColor());
                    swap(i, j, i, j + 1); // 다시 원상태로 교환
                }

                if (i + 1 < n && arr[i][j] != arr[i + 1][j]) {
                    swap(i, j, i + 1, j); // 아래쪽과 교환
                    answer = Math.max(answer, sameColor());
                    swap(i, j, i + 1, j); // 우리는 스왑 전후로 최대값을 구해야 하기 때문에 원래 상태의 배열을 유지시켜야 됨
                }
            }
        }
        System.out.println(answer);

    }

    static void swap(int x1, int y1, int x2, int y2) { // 인접한 두 사탕 교환
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static int sameColor() { // 현재 행, 열 연속된 색상의 캔디 최대 개수 구하는 함수
        int max = 1;

        // 행 기준 검사
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 열 기준 검사
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}