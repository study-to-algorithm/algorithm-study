import java.util.*;
import java.io.*;
/*
 * 실버 4 스택
 */

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean isValid = true; // no 출력하는 경우에 대해 검증
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                if(c == '('){ // '(' 라면 스택에 추가
                    stack.push(c);
                }else if(c == ')'){ // ')'라면 스택에서 '(' 제거
                    if(stack.isEmpty()){ // 근데 만약 스택이 비어있는 우
                        isValid = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && isValid){ // 스택이 비어있고 검증 참이면 yes
                System.out.println("YES");
            }else{ // 아닐 경우
                System.out.println("NO"); // 노 출력
            }
        }
    }
}