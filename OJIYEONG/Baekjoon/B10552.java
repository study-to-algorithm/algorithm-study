/*
[DFS]
백준 10552번 DOM
 */

import java.util.*;

public class Main {

    static int n; // 연금 수급자 수
    static int m; // TV 채널 수
    static int p; // 첫 채널

    static int[] disToLike;
    static boolean[] visited;

    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();

        disToLike = new int[m+1];
        Arrays.fill(disToLike, -1); // 우선 전부 -1로 매핑

        for (int i = 0; i < n; i++) {
            int like = sc.nextInt();
            int dislike = sc.nextInt();
            if (disToLike[dislike] == -1) { // 어린 사람 값만 있으면 됨
                disToLike[dislike] = like; // 싫어하는 채널 -> 좋아하는 채널로 매핑 설정
            }
        }

        visited = new boolean[m+1];
        cnt = 0;

        dfs(p);

//        System.out.println(cnt == -1 ? -1 : cnt-1);
        System.out.println(cnt);


    }

    static void dfs(int ch) {

        // 첫 채널도 +1됨
//        if (visited[ch]) {
//            cnt = -1;
//            return;
//        }
//
//        visited[ch] = true;
//        cnt++;
//
//        if (disToLike[ch] == -1) { // 현재 채널(ch)을 싫어해서 바꾸려는 사람이 없음
//            return;
//        }
//
//        dfs(disToLike[ch]);


        if (visited[ch])  {
            cnt = -1;
        } else if (disToLike[ch] != -1) {
            visited[ch] = true;
            cnt++;
            dfs(disToLike[ch]);
        }

    }

}
