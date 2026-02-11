import java.io.*;
import java.util.*;

/**
 * 실버 4 구현
 * 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
 */

public class B20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] cookie = new boolean[n][n]; // 쿠키 신체
        int[] body = new int[5]; // 각 신체 길이

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                char c = str.charAt(j);
                if(c == '*') cookie[i][j] = true; // 배열에 저장
            }
        }

        int heartC = -1, heartR = -1; // 머리, 허리 위치
        outer: for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(cookie[i][j]&&
                        cookie[i-1][j]&&
                        cookie[i+1][j]&&
                        cookie[i][j-1]&&
                        cookie[i][j+1]) {

                    heartC = j;   // 심장 열
                    heartR = i;      // 심장 행
                    break outer;
                }
            }
        }

        for (int j = heartC - 1; j >= 0; j--) { // 왼쪽 팔
            if (cookie[heartR][j]) body[0]++;
            else break;
        }
        for (int j = heartC + 1; j < n; j++) { // 오른쪽 팔
            if (cookie[heartR][j]) body[1]++;
            else break;
        }

        for (int i = heartR + 1; i < n; i++) { // 허리 길이
            if (cookie[i][heartC]) body[2]++;
            else break;
        }

        int leg = heartR + body[2] + 1;
        for (int i = leg; i < n; i++) { // 왼쪽 다리
            if (cookie[i][heartC - 1]) body[3]++;
            else break;
        }

        for (int i = leg; i < n; i++) { // 오른족 다리
            if (cookie[i][heartC + 1]) body[4]++;
            else break;
        }


        System.out.println((heartR + 1) + " " + (heartC + 1)); // 인덱스는 0부터 시작, 길이는 1부터 시작
        for(int i = 0; i < 5; i++){
            System.out.print(body[i] + " ");
        }

    }
}