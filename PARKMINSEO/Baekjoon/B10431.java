import java.util.*;
import java.io.*;

/** 실버 5 구현
 * 자신보다 키 큰 사람을 찾으면 되는 문제
 */


public class B10431 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            int[] arr = new int[20];
            int cnt = 0; // 뒤로 물러난 걸음 수의 총합
            for(int j = 0; j < 20; j++){
                int height = Integer.parseInt(st.nextToken());
                arr[j] = height;
                for(int k = 0; k < j; k++){
                    if(arr[k] > height) cnt++;
                }
            }
            System.out.println(n + " " + cnt);
        }
    }
}