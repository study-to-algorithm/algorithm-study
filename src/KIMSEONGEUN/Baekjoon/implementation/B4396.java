package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 지뢰찾기 (실버 4)
public class B4396 {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] mapInit = new char[n][n]; // 지뢰 위치
        char[][] mapOpen = new char[n][n]; // 열린 위치
        char[][] map = new char[n][n]; // 결과


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                mapInit[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                mapOpen[i][j] = line.charAt(j);
            }
        }

        boolean isLose = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mapOpen[i][j] == 'x') {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (mapInit[nx][ny] == '*') {
                                count++;
                            }
                        }
                    }
                    // 숫자 -> 문자 변환
                    map[i][j] = (char) (count + '0');

                    if (mapInit[i][j] == '*') isLose = true;
                } else {
                    map[i][j] = '.';
                }
            }
        }

        if (isLose) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mapInit[i][j] == '*') {
                        map[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
