package KIMSEONGEUN.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제: 프린터 큐 (실버 3)
public class B1966 {

    static class Doc {
        int idx;
        int pri;

        Doc(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Doc> q = new ArrayDeque<>();
            int[] countPri = new int[10]; // priority 1~9 카운트

            for (int i = 0; i < n; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.add(new Doc(i, p));
                countPri[p]++;
            }

            int printed = 0;

            while (!q.isEmpty()) {
                Doc cur = q.poll();

                // 현재 남아있는 문서 중 최고 우선순위 찾기
                int maxP = 9;
                while (maxP > 0 && countPri[maxP] == 0) maxP--;

                if (cur.pri == maxP) {
                    // 출력
                    printed++;
                    countPri[cur.pri]--;

                    if (cur.idx == m) {
                        sb.append(printed).append('\n');
                        break;
                    }
                } else {
                    // 뒤로 보내기
                    q.add(cur);
                }
            }
        }

        System.out.print(sb);
    }
}
