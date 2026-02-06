import java.util.*;
import java.io.*;

/** 실버 5 구현
 */


public class B4659 {
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 스위치의 개수
        switches = new int[n + 1]; // 스위치 상태 0: off, 1: on

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(st.nextToken());
            switches[i] = a;
        }

        int k = Integer.parseInt(br.readLine()); // 학생 인원
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken()); // 학생 성별, 1: m, 2:fm
            int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            if(gen == 1){ // 학생이 남자라면
                int a = 1;
                while(num * a <= n){
                    turn(num * a);
                    a++;
                }
            }else{ // 학생이 여자라면
                turn(num);
                int a = num - 1;
                int b = num + 1;

                while(a >= 1 && b <= n && switches[a] == switches[b]){
                    turn(a);
                    turn(b);
                    a--;
                    b++;
                }
            }

        }
        for(int i = 1; i <= n; i++){
            System.out.print(switches[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }

    static void turn(int n){
        switches[n] = switches[n] == 0 ? 1 : 0;
    }
}