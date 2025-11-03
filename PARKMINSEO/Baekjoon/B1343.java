import java.util.*;
import java.io.*;
/*
그리디 알고리즘 : 현재 상태에서 최고의 수를 선택해서 해를 찾는 것
->큰 수를 기준으로 찾기
왜 컴파일 에러? length 괄호...
*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken(); //보드판
        int cnt = 0; // 폴리오미노 계산하기 위한 x의 개수
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) == 'X'){ // 만약 현재 문자가 X라면
                cnt++; // 카운트 증가
            }else{
                if(cnt % 2 != 0) { // 만약 X의 개수가 홀수라면
                    System.out.println(-1); // -1 print
                    return;
                }
                sb.append("AAAA".repeat(cnt / 4)); // cnt/4 만큼 AAAA 추가
                sb.append("BB".repeat(cnt % 4 / 2)); // 나머지만큼 BB 추가
                cnt = 0;
                sb.append(".");
            }
        }
        // 마지막에 X로 끝난 경우 처리
        if(cnt > 0){
            if (cnt % 2 != 0) {
                System.out.println(-1);
                return;
            }
            sb.append("AAAA".repeat(cnt / 4));
            sb.append("BB".repeat((cnt % 4) / 2));
        }
        System.out.println(sb.toString());
    }
}