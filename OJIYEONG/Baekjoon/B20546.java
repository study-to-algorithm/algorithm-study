/*
[구현(시뮬레이션)]
백준 20546번 기적의 매매법

BNP:
- 매일 살 수 있으면 전부 매수

TIMING:
- 3일 연속 하락 -> 전액 매수
- 3일 연속 상승 -> 전액 매도

14일 후 자산 비교
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        int[] price = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // BNP
        int bnpMoney = money;
        int bnpStock = 0;

        for (int i = 0; i < 14; i++) {
            if (bnpMoney >= price[i]) {
                int buy = bnpMoney / price[i];
                bnpStock += buy;
                bnpMoney -= buy * price[i];
            }
        }

        int bnpTotal = bnpMoney + bnpStock * price[13];

        // TIMING
        int timingMoney = money;
        int timingStock = 0;

        for (int i = 3; i < 14; i++) {

            // 3일 연속 하락
            if (price[i - 3] > price[i - 2] &&
                    price[i - 2] > price[i - 1] &&
                    price[i - 1] > price[i]) {

                if (timingMoney >= price[i]) {
                    int buy = timingMoney / price[i];
                    timingStock += buy;
                    timingMoney -= buy * price[i];
                }
            }

            // 3일 연속 상승
            else if (price[i - 3] < price[i - 2] &&
                    price[i - 2] < price[i - 1] &&
                    price[i - 1] < price[i]) {

                timingMoney += timingStock * price[i];
                timingStock = 0;
            }
        }

        int timingTotal = timingMoney + timingStock * price[13];


        if (bnpTotal > timingTotal) {
            System.out.println("BNP");
        } else if (bnpTotal < timingTotal) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
