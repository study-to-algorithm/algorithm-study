import java.util.*;
import java.io.*;
/**
 * 실버 1 스택
 * 스택을 배열로 사용할때 선언과 초기화는 다르기 때문에 초기화 필수
 */

public class B2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 음의 수
        int p = Integer.parseInt(st.nextToken()); // 프렛의 수
        Stack<Integer>[] stacks = new Stack[7]; // 스택을 배열로 만들기
        for (int i = 1; i <= 6; i++) { // 스택 초기화
            stacks[i] = new Stack<>();
        }

        int cnt = 0; // 손가락 움직임 횟수
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken()); // 줄의 번호
            int pn = Integer.parseInt(st.nextToken()); // 프렛의 번호

            while(!stacks[nn].isEmpty() && stacks[nn].peek() > pn){ // 현재 프렛 번호보다 클 경우에만 반복해서 pop
                stacks[nn].pop();
                cnt++;
            }

            if(stacks[nn].isEmpty() || stacks[nn].peek() != pn){ // 스택이 비어있는 경우/스택에 이미 있는 값인 경우를 고려해서 같지 않는 경우에만 스택에 추가
                stacks[nn].push(pn); // push
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}