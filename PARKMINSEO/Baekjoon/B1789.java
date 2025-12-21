import java.util.*;
import java.io.*;
/*
 * 그리디 실버 5
 * 1부터 더한 다음 더한 값이 n 이상일 경우, 현재 더한 값에서 1을 빼면 그게 바로 자연수 최대값(최대 개수)
 */

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long i = 0;

        while(true){
            sum += ++i;
            if(sum > n) { // 1부터 더한 값이 n 이상일 경우 자연수 최대값은 i - 1
                break;
            }
        }
        System.out.println(--i);
    }
}