package KIMSEONGEUN.Baekjoon.bf;

import java.util.Scanner;

// 문제: 영화감독 숌 (실버 5)
public class B1436 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int count = 0;
        int num = 666;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++;
                if (count == k) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}
