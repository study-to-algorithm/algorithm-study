import java.util.*;
import java.io.*;
/*
 1. 먼저 뺄셈을 기준으로 수를 나눠서 더한 다음
 2. 빼기를 수행하면 됨
*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitM = br.readLine().split("-"); // -로 나누기
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < splitM.length; i++){
            int temp = 0;
            String[] splitP = splitM[i].split("\\+"); // +로 나누기, split은 정규식을 받음
            for(int j = 0; j < splitP.length; j++){ // +로 나눈 값들 모두 더하기
                temp += Integer.parseInt(splitP[j]);
            }
            if(sum == Integer.MAX_VALUE){ // 첫 글자는 양수이니깐 첫 글자를 패스하기 위한 목적
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}