/*
[수학]
백준 1735번 분수 합

두 분수의 합을 기약분수 형태로 출력

A/B , C/D
-> (A*D + C*B) / (B*D)
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int numerator = A * D + C * B; // 분자
        int denominator = B * D; // 분모

        int g = gcd(numerator, denominator); // 최대 공약수
        numerator /= g;
        denominator /= g;

        System.out.println(numerator + " " + denominator);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
