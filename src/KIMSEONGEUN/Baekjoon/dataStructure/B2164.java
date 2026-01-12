package KIMSEONGEUN.Baekjoon.dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 문제: 카드2 (실버 4)
public class B2164 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
                q.poll();
                q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
