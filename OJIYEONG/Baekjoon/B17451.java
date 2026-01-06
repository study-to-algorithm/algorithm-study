/*
[그리디]
백준 17451번 평행 우주

뒤에서부터 필요한 최소 속도 계산

speed = 마지막 행성의 최소 속도

이전 행성 i에 대해:
- speed >= v[i]
- speed는 v[i]의 배수여야 함

=> speed = ceil(speed / v[i]) * v[i]
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] v = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }

        long speed = v[N - 1]; // 마지막 행성

        for (int i = N - 2; i >= 0; i--) {
            long cur = v[i];

            if (speed % cur != 0) {
                speed = (speed / cur + 1) * cur;
            }
        }

        System.out.println(speed);
    }
}
