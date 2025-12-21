import java.util.*;
import java.io.*;
/*
 * 실버 3 문자열
 * 그냥 문제 잘 읽고 풀면 됨^^
 */

public class B3568{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.substring(0, s.length() - 1).split(" ", 2); // 첫번째 공백을 기준으로 2개로 나눔(마지막 ;제외)
        String base = str[0]; // 기본 변수형
        String[] var = str[1].split(", "); // 추가 변수형은 ,로 나눔

        for(int i = 0; i < var.length; i++){
            StringBuilder type = new StringBuilder(base);
            StringBuilder name = new StringBuilder();
            for(int j = var[i].length() - 1; j >= 0; j--){
                char c = var[i].charAt(j);
                if(c == '*' || c == '&'){
                    type.append(c);
                }else if(c == ']'){
                    type.append("[]");
                    j--; // '[' 건너뛰어야 함
                }else{
                    name.append(c); // 이때 문자열이 뒤집힌 상태로 저장되기 때문에 마지막에 뒤집어야 됨
                }
            }
            System.out.println(type.toString() + " " + name.reverse().toString() + ";");
        }
    }
}