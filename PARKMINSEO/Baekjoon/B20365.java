import java.util.*;
import java.io.*;
/*
먼저 블루와 레드 중 더 적은 개수를 찾아서
더 많은 색상으로 먼저 칠한 다음 적은 개수의 색상을 칠하면 최소값 출력될 것
ex. bbrbr -> b > r이기 때문에 bbbbb -> bbrbb -> bbrbr 이런 순서로 최소값 추출
*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int b = 0; // 블루로 칠할 개수
        int r = 0; // 레드로 칠할 개수
        String s = ""; // 연속 문자열을 비교하기 위한 변수
        for(int i = 0; i < n; i++){
            if(!s.equals(str[i])){ // 현재 문자열이 이전 값과 같지 않다면 카운트 증가
                if(str[i].equals("B"))
                    b++;
                else
                    r++;
                s = str[i];
            }
        }
        System.out.println(Math.min(b, r) + 1);
    }
}