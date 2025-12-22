/*
[완전탐색]
백준 1436번 영화감독 숌

종말의 수: 숫자 안에 "666"이 연속으로 포함된 수


현재 숫자 x:
1)
문자열로 변환
2)
"666"이 포함되어 있으면 종말의 수

-> 종말의 수를 찾을 때마다 count++
=> count == N 이 되는 순간의 숫자가 정답


N ≤ 10000
→ 전부 직접 확인해도 충분
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666; // 첫 종말의 수부터 시작

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++;
                if (count == N) {
                    System.out.println(num);
                    return;
                }
            }
            num++;
        }
    }
}
