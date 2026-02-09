package KIMSEONGEUN.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 기적의 매매법 (실버 5)
public class B20546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int jhMoney = money;
        int smMoney = money;
        int jhCount = 0;
        int smCount = 0;

        int[] prices = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 준현
        for (int i = 0; i < prices.length; i++) {
            if (jhMoney >= prices[i]) {
                jhCount += jhMoney / prices[i];
                jhMoney %= prices[i];
            }
        }

        // 성민
        for (int i = 3; i < 14; i++) {
            // 3일 연속 하락 (매수)
            if (prices[i-3] > prices[i-2] && prices[i-2] > prices[i-1] && prices[i-1] > prices[i]) {
                smCount += smMoney / prices[i];
                smMoney %= prices[i];
            }
            // 3일 연속 상승 (매도)
            else if (prices[i-3] < prices[i-2] && prices[i-2] < prices[i-1] && prices[i-1] < prices[i]) {
                smMoney += smCount * prices[i];
                smCount = 0;
            }
        }

        int jhTotal = jhMoney + (jhCount * prices[13]);
        int smTotal = smMoney + (smCount * prices[13]);

        if (jhTotal > smTotal) {
            System.out.println("BNP");
        } else if (jhTotal < smTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
