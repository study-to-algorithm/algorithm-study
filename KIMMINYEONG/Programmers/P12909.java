package Programmers;
import java.util.*;

class P12909 {
    boolean solution(String s) {
        Stack <Character> t = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //여는 괄호
            if(c == '('){
                t.push(c);
            } 
            // 닫는 괄호
            else if(c ==')'){
                if(t.isEmpty()){
                    return false;
                } // 이게 없으면 emptyException 발생
                t.pop();
            }
        } return t.isEmpty();
    }
}
