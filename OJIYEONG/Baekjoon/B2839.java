/*
[그리디]
백준 2839번 설탕 배달

3kg 하나씩 + -> 남은 무게 5의 배수인지 확인
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 3;
            count++;
        }

        System.out.println(-1);
    }
}