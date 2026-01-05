import java.util.*;
import java.io.*;
/*
 * 실버 2 스택
 * ()가 연속해서 나오면 레이저 구간
 * 스택에는 아직 닫히지 않은 괄호('(')가 바로 겹쳐져 있는 쇠막대기 개수
 * 따라서, ()이 나오면 스택에 남아있는 문자의 개수대로 카운트에 추가해주면 됨
 */

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int cnt = 0; // 막대 카운트

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){ // '('
                stack.push(c);
            }else{ // ')'
                stack.pop(); // ')'를 만나면 팝
                if(str.charAt(i - 1) == '(') { // 이전 문자가 '('라면 연속해서 ()이 됨 -> 레이저 구간
                    cnt += stack.size();
                }else{
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}