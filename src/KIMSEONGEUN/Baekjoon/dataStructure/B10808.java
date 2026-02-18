package KIMSEONGEUN.Baekjoon.dataStructure;

import java.util.Scanner;

// 문제: 알파벳 개수 (브론즈 4)
public class B10808 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int k = str.charAt(i) - 'a';
            freq[k] += 1;
        }

        for (int i : freq) {
            System.out.print(i + " ");
        }
    }
}
