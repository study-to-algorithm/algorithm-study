/*
문제 링크 : https://www.acmicpc.net/status?user_id=lucy9150&problem_id=11720&from_mine=1
시간 : 108ms
메모리 : 14220KB
접근 방법 : Do it! 코딩테스트 - 배열과 리스트 편
*/
import java.util.*;
import java.io.*;

public class B11720{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += s.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}