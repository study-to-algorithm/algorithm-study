import java.util.*;
import java.io.*;
/*
그리디 알고리즘 : 현재 상태에서 최고의 수를 선택해서 해를 찾는 것
->큰 수를 기준으로 찾기
2+1을 할때 가장 싼 제품을 무료로 제공
최대한 가격이 높은 것끼리 묶어야 비싼 제품을 무료로 받을 수 있음
*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 유제품 개수
        int[] price = new int[n]; // 가격을 담을 배열
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken()); // 가격
        }
        int bal = n % 3; // 3개의 묶음에 노 포함
        int sum = 0; // 총 가격
        Arrays.sort(price);
        for(int i = n - 1; i >= 0; i--){
            if((n - i) % 3 != 0){  // 3의 배수 = 3개의 묶음에서 가장 싼 값이 아닐때
                sum += price[i];
            }
        }
        System.out.println(sum);
    }
}