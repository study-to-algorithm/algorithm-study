import java.util.*;
import java.io.*;
/*
 * 실버 3 큐
 */

public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 찾는 문서의 위치
            Queue<int[]> que = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int a = Integer.parseInt(st.nextToken()); // 문서의 중요도
                que.add(new int[] {j, a}); // 큐에 순서, 중요도 저장
            }

            int cnt = 0;
            while(true){
                int[] po = que.poll(); // 우선 처음에 넣은 거 제거해서 저장
                boolean check = true; // 더 큰 수가 있는지 확인하는 용도

                for(int[] data : que){
                    if(po[1] < data[1]) { // 처음에 제거한 값을 기준으로 남은 큐에 더 큰 수가 있는지 확인
                        check = false;
                        break;
                    }
                }
                if(check){ // 찾는 문서의 위치에 있고 더 큰 수가 없다면
                    cnt++;
                    if(po[0] == m){
                        break;
                    }
                }else { // 더 큰 수가 존재한다면
                    que.add(po); // 다시 큐에 저장
                }

            }
            System.out.println(cnt);
        }
    }
}