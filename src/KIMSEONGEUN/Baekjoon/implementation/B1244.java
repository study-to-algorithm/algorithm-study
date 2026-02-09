package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 스위치 켜고 끄기 (실버 4)
public class B1244 {

    public static void main(String[] args) throws IOException {

        // 1 = 스위치 켜져 있음, 0 = 스위치 꺼져 있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());

        int[] switches = new int[switchNum+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= switchNum; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 남학생: 스위치 번호가 자기가 받은 배수이면 스위치 상태 바꿈
                for (int j = num; j <= switchNum; j += num) {
                    switches[j] = (switches[j] == 0) ? 1 : 0;
            }
        }

            else if (gender == 2) {
                // 여학생: 스위치 번호 좌우를 중심으로 대칭이면 구간에 속한 스위치 상태 모두 바꿈
                //        대칭이 아니면 자기가 받은 스위치만 바꿈
                switches[num] = (switches[num] == 0) ? 1 : 0;

                int center = num;

                int left = center - 1;
                int right = center + 1;

                while ((left >= 1) && (right <= switchNum) && (switches[left] == switches[right])) {
                    switches[left] = (switches[left] == 0) ? 1 : 0;
                    switches[right] = (switches[right] == 0) ? 1 : 0;

                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= switchNum; i++) {
            System.out.print(switches[i] + " ");

            if (i % 20 == 0) System.out.println();
        }
    }
}
