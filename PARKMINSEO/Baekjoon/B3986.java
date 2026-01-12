import java.util.*;
import java.io.*;
/**
 * 실버 4 스택
*/

public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 0; // 좋은 단어가 되는 카운트
        for(int i = 0; i < t; i++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isCount = false; // 해당 문자열에 좋은 글자가 있는 경우에는 참, 아니면 거짓
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                if(stack.isEmpty()){ // 스택이 비어있다면 스택에 추가
                    stack.push(c);
                }else if(stack.peek() != c){ // 스택 상단에 있는 값이 현재 문자와 다르다면 이때도 추가
                    stack.push(c);
                }else if(stack.peek() == c){ // 스택 상단에 있는 값이 현재 문자와 같다면 제거
                    stack.pop();
                    isCount = true;
                }
            }
            if(stack.isEmpty() && isCount){ // 스택이 비어있고 isCount가 참인 경우에만 카운트 증가
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}