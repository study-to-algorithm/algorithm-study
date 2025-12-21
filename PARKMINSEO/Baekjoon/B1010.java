import java.util.*;
import java.io.*;
/*
 * 실버 5
 * 동쪽 다리의 개수 중에 서쪽 다리의 개수만큼 조합하면 되는 문제 nCr
 * 팩토리얼의 경우 다 곱한 값으로 계산하기에는 오버플로우 발생하기 때문에 매번 나누는 방식으로
 */

public class B1010{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == b){
                System.out.println(1);
                continue;
            }
            int result = 1;
            for(int j = 1; j <= a; j++){
                result = result * (b - j + 1) / j; // 조합, nCr = n!/(r! * n-r!)
            }
            System.out.println(result);
        }
    }
}