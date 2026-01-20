import java.io.*;
import java.util.*;

/**
 * 실버 3 문자열
 * 정규식으로 풀면 쉽게 해결
 * [] : 괄호 안의 글자가 있는지 확인
 * $ : $ 앞의 있는 문자로 끝나는지 확인
 * ? : 0 ~ 1
 * + : 1 ~
 *
 */

public class B9342 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String str = br.readLine();
            System.out.println(str.matches("[A-F]?A+F+C+[A-F]?$") ? "Infected!" : "Good");
        }
    }
}