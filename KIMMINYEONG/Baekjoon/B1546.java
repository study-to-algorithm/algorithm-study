/*
문제 링크 : https://www.acmicpc.net/status?user_id=lucy9150&problem_id=1546&from_mine=1
시간 : 108ms
메모리 : 14404KB
접근 방법 : Do it! 코딩테스트 - 배열과 리스트 편
*/
import java.util.*;
import java.io.*;

public class B1546{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] b = new double[n];
        double max = 0;

        for(int i = 0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
            if(b[i]>max) max = b[i];
        }

        int sum = 0;

        for(int t=0; t<n; t++){
            sum += b[t];
        }

        System.out.println(sum/max*100/n);
    }
}