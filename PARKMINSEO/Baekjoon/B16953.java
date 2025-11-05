import java.util.*;
import java.io.*;
/*
1. 2를 곱한다.
2. 1을 수의 가장 오른쪽에 추가한다.
두 가지 방식을 이용해 a -> b를 만드는 규칙
문제 해결 방법
반대로 풀면 되지 않을까
b->a로 우선 b의 맨 오른쪽 숫자가 1이면 1을 빼고
나눗셈을 해서 a가 되면 되지 않을까?
*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int cnt = 1; // 필요한 연산의 개수
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        while(b > a){ //b가 a 이상일때까지 반복
            if(b % 10 == 1){ // b의 마지막 숫자가 1이면 1 빼기
                b /= 10;
            }else if(b % 2 == 0){ // 2로 나눠지면 2로 나누기
                b /= 2;
            }else{ // 위와 같은 상황이 아니라면 -1 출력
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        if(b == a){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
    }
}