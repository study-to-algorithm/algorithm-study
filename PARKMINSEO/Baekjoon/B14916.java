import java.util.*;
import java.io.*;
/*
그리디 알고리즘 : 현재 상태에서 최고의 수를 선택해서 해를 찾는 것
->큰 수를 기준으로 찾기

*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 거스름돈 금액
        int count = 0; // 최소 개수
        if(n >= 5){ // 금액이 5보다 크면 먼저 5부터 계산
            count += n/5;
            n %= 5; // n에서 해당 금액만큼 차감

            if(n % 2 != 0){ // 이때 남은 금액이 홀수라면
                count--; // 개수 하나 다시 차감
                n += 5; // 금액도 다시 추가
            }
        }
        count += n/2;
        n %= 2;
        if(n != 0){
            System.out.println(-1);
        }else {
            System.out.println(count);
        }

    }
}