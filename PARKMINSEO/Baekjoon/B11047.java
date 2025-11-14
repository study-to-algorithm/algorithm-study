import java.util.*;
import java.io.*;
/*
그리디 알고리즘 : 현재 상태에서 최고의 수를 선택해서 해를 찾는 것
-> 여기서는 큰 수를 기준으로 찾기

그리디를 사용하려면 반례을 생각해야 됨 -> 그리디는 최적의 수를 보장하지 않기 때문에
A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수 -> 이 조건 때문에 그리디 알고리즘을 사용할 수 있는 문제가 됨
*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류
        int k = Integer.parseInt(st.nextToken()); // 목표 금액
        int[] money = new int[n]; // 동전 금액 저장
        int count = 0; // 최소 동전 개수 저장
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n - 1; i >= 0; i--){
            if(k == 0){ // 목표 금액에 달성했으면
                break;  // 스탑
            }
            if(k >= money[i]){
                count += k/money[i];
                k %= money[i];
            }
        }
        System.out.println(count);
    }
}