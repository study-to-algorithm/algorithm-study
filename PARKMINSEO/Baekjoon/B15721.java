import java.io.*;
import java.util.*;

/**
 * 실버 5 브루트포스
 */

public class B15721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); // 사람 수
        int t = Integer.parseInt(br.readLine()); // 구하는 번째
        int s = Integer.parseInt(br.readLine()); // 구하는 구호(0: 뻔, 1: 데기)

        int bCnt = 0; // 뻔 카운트
        int dCnt = 0; // 데기 카운트
        int cnt = 0; // 반복 카운트
        while(true){
            for(int i = 0; i < 4; i++){ // 번-데기-번-데기, 매번 고정적
                if(i % 2 == 0) bCnt++; // 짝수일 때는 번++
                else dCnt++; // 홀수일 때는 데기++

                if(s == 0 && t == bCnt) { // 만약 구호가 뻔일 경우 해당 번째까지 도달했을 경우
                    System.out.println((bCnt + dCnt - 1) % a); // 총 횟수는 두개를 합한 값, 총 횟수에서 1을 빼고 a로 나누면 t번째에 해당하는 사람 번호
                    return;
                }
                if(s == 1 && t == dCnt) { // 만약 구호가 데기일 경우 해당 번째까지 도달했을 경우
                    System.out.println((bCnt + dCnt - 1) % a); // 총 횟수는 두개를 합한 값, 총 횟수에서 1을 빼고 a로 나누면 t번째에 해당하는 사람 번호
                    return;
                }
            }
            for(int i = 0; i <= cnt + 1; i++){ // 고정적이지 않은 부분, 번-번-데기-데기에서 번-번
                bCnt++;
                if(s == 0 && t == bCnt) { // 만약 구호가 뻔일 경우 해당 번째까지 도달했을 경우
                    System.out.println((bCnt + dCnt - 1) % a); // 총 횟수는 두개를 합한 값, 총 횟수에서 1을 빼고 a로 나누면 t번째에 해당하는 사람 번호
                    return;
                }
            }

            for(int i = 0; i <= cnt + 1; i++){ // 데기-데기-데기
                dCnt++;
                if(s == 1 && t == dCnt) { // 만약 구호가 뻔일 경우 해당 번째까지 도달했을 경우
                    System.out.println((bCnt + dCnt - 1) % a); // 총 횟수는 두개를 합한 값, 총 횟수에서 1을 빼고 a로 나누면 t번째에 해당하는 사람 번호
                    return;
                }
            }
            cnt++;
        }
    }
}